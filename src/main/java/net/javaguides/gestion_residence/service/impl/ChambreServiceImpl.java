package net.javaguides.gestion_residence.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
import net.javaguides.gestion_residence.mapper.ChambreMapper;
import net.javaguides.gestion_residence.repository.ChambreRepository;
import net.javaguides.gestion_residence.repository.ResidenceRepository;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements ChambreService {

    @Autowired
    private ResidenceRepository residenceRepository;

    @Autowired
    private ResidentRepository residentRepository;



    @Autowired
        private ChambreRepository chambreRepository;


        //crer chambre
        @Override
        public ChambreDto saveChambre(ChambreDto chambreDto) {
            Chambre chambre = ChambreMapper.mapToChambre(chambreDto);

            // Associer Residence si l'ID existe
//            if (chambreDto.getResidenceId() != null) {
//                chambre.setResidence(residenceRepository.findById(chambreDto.getResidenceId())
//                        .orElseThrow(() -> new RuntimeException("Residence non trouvée")));
//            }
//
//            // Associer Resident si l'ID existe
//            if (chambreDto.getResidentId() != null) {
//                chambre.setResident(residentRepository.findById(chambreDto.getResidentId())
//                        .orElseThrow(() -> new RuntimeException("Resident non trouvé")));
//            }

            chambre.setDisponible(true); // Par défaut, la chambre est disponible
            Chambre savedChambre = chambreRepository.save(chambre);

            return ChambreMapper.mapToChambreDTO(savedChambre);
        }






    // Get Chambre by ID
    @Override
    public ChambreDto getChambre(Long id) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Chambre non trouvée avec l'ID : " + id));

        return ChambreMapper.mapToChambreDTO(chambre);
    }
    // Get all Chambres
    @Override
    public List<ChambreDto> getAllChambres() {
        List<Chambre> chambres = chambreRepository.findAll();
        return ChambreMapper.mapToChambreDTOList(chambres);  // Assuming you have a method to convert list to DTO
    }
    // Get all available Chambres
    @Override
    public List<ChambreDto> getAvailableChambres() {
        List<Chambre> chambres = chambreRepository.findByDisponibleTrue();
        return ChambreMapper.mapToChambreDTOList(chambres);  // Assuming you have a method to convert list to DTO
    }

    @Override
    public ChambreDto updateChambre(Long id, ChambreDto chambreDto) {
        // Fetch the existing Chambre from the database by ID
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre non trouvée avec l'ID : " + id));

        // Update the properties of the existing chambre with new values
        chambre.setTaille(chambreDto.getTaille());
        chambre.setDisponible(chambreDto.isDisponible());
        // Set other properties as necessary, based on the chambreDto fields

        // Save the updated Chambre entity
        Chambre updatedChambre = chambreRepository.save(chambre);

        // Return the updated chambre as a DTO
        return ChambreMapper.mapToChambreDTO(updatedChambre);
    }
    @Override
    public void deleteChambre(Long id) {
        // Check if the Chambre exists before deleting
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Chambre non trouvée avec l'ID : " + id));

        // Delete the Chambre from the repository
        chambreRepository.delete(chambre);
    }




//        public List<Chambre> getAllChambres() {
//            return chambreRepository.findAll();
//        }
//
//        public List<Chambre> getAvailableChambres() {
//            return chambreRepository.findByDisponibleTrue();
//
//        }
//
//
//
//        public void deleteChambre(Long id) {
//            chambreRepository.deleteById(id);
//        }

}
