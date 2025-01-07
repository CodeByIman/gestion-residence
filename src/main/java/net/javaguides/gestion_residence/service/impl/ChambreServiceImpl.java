package net.javaguides.gestion_residence.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
import net.javaguides.gestion_residence.mapper.ChambreMapper;
import net.javaguides.gestion_residence.repository.ChambreRepository;
import net.javaguides.gestion_residence.repository.ResidenceRepository;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private ResidentRepository residentRepository;



    @Autowired
        private ChambreRepository chambreRepository;




        @Override
        public ChambreDto saveChambre(ChambreDto chambreDto) {
            Resident resident = null;
            if (chambreDto.getResidentId() != null) {
                resident = residentRepository.findById(chambreDto.getResidentId())
                        .orElseThrow(() -> new RuntimeException("Resident non trouvé"));
            }
            Chambre chambre = ChambreMapper.mapToChambre(chambreDto, resident);  // Pass resident here
            Chambre savedChambre = chambreRepository.save(chambre);
            // Assignez l'ID de la chambre au resident et enregistrez la mise à jour
            if (resident != null) {
                resident.setChambreId(savedChambre.getId());
                residentRepository.save(resident);  // Sauvegardez les changements pour le résident
            }

            return ChambreMapper.mapToChambreDTO(savedChambre);
        }


        @Override
        public ChambreDto getChambre(Long id) {
            Chambre chambre = chambreRepository.findById(id)
                    .orElseThrow(() -> new RessourceNotFoundException("Chambre non trouvée avec l'ID : " + id));
            return ChambreMapper.mapToChambreDTO(chambre);
        }

        @Override
        public List<ChambreDto> getAllChambres() {
            List<Chambre> chambres = chambreRepository.findAll();
            return ChambreMapper.mapToChambreDTOList(chambres);
        }

        @Override
        public List<ChambreDto> getAvailableChambres() {
            List<Chambre> chambres = chambreRepository.findByStatus(Chambre.Status.DISPONIBLE);
            return ChambreMapper.mapToChambreDTOList(chambres);
        }

        @Override
        public ChambreDto updateChambre(Long id, ChambreDto chambreDto) {
            Chambre chambre = chambreRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Chambre non trouvée avec l'ID : " + id));

            chambre.setTaille(chambreDto.getTaille());
            chambre.setEquipements(chambreDto.getEquipements());

            if (chambreDto.getStatus() != null) {
                chambre.setStatus(Chambre.Status.valueOf(chambreDto.getStatus().name()));
            }

            if (chambreDto.getResidentId() != null) {
                Resident resident = residentRepository.findById(chambreDto.getResidentId())
                        .orElseThrow(() -> new RuntimeException("Resident non trouvé"));
                chambre.setResident(resident);
            } else {
                chambre.setResident(null);
            }

            Chambre updatedChambre = chambreRepository.save(chambre);
            return ChambreMapper.mapToChambreDTO(updatedChambre);
        }

        @Override
        public void deleteChambre(Long id) {
            Chambre chambre = chambreRepository.findById(id)
                    .orElseThrow(() -> new RessourceNotFoundException("Chambre non trouvée avec l'ID : " + id));
            chambreRepository.delete(chambre);
        }

    @Override
    @Transactional
    public void assignResidentToChambre(long chambreId, long residentId) {
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new IllegalArgumentException("Chambre not found with ID: " + chambreId));
        Resident resident = residentRepository.findById(residentId)
                .orElseThrow(() -> new IllegalArgumentException("Resident not found with ID: " + residentId));
        resident.setChambreId(chambreId);  // Assign the chambreId to the resident

        chambre.setResident(resident);
        // Sauvegarder les entités mises à jour
        residentRepository.save(resident);  // Sauvegarde du résident
        chambreRepository.save(chambre);    // Sauvegarde de la chambre (si nécessaire)// Save the updated resident
    }

//    @Override
//    public Chambre libererChambre(Long chambreId) {
//        Chambre chambre = chambreRepository.findById(chambreId)
//                .orElseThrow(() -> new RessourceNotFoundException("Chambre non trouvée avec id : " + chambreId));
//
//        if (chambre.getResident() != null) {
//            Resident resident = chambre.getResident();
//            resident.setChambreId(null);  // Détacher la chambre du résident
//            chambre.setResident(null);  // Supprimer le résident de la chambre
//            chambre.setStatus(Chambre.Status.DISPONIBLE);  // Mettre le statut à disponible
//
//            residentRepository.save(resident);  // Sauvegarder les changements
//            chambreRepository.save(chambre);    // Sauvegarder les changements
//        }
//        return chambre;
//    }
    }
