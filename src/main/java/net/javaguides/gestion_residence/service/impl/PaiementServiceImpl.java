package net.javaguides.gestion_residence.service.impl;

import net.javaguides.gestion_residence.dto.PaiementDto;
import net.javaguides.gestion_residence.entity.Paiement;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
import net.javaguides.gestion_residence.mapper.PaiementMapper;
import net.javaguides.gestion_residence.mapper.ResidentMapper;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.repository.PaiementRepository;
import net.javaguides.gestion_residence.service.PaiementService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaiementServiceImpl  implements PaiementService {

    @Autowired
    private PaiementRepository PaiementRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public List<PaiementDto> getAllPaiements() {
        List<Paiement> paiements = PaiementRepository.findAll();
        return paiements.stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaiementDto> getPaiementsByResidentId(Long residentId) {
        List<Paiement> paiements = PaiementRepository.findByResidentId(residentId);
        return paiements.stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override

    public PaiementDto addPaiement(PaiementDto paiementDTO) {
        Resident resident = residentRepository.findById(paiementDTO.getResidentId())
                .orElseThrow(() -> new RessourceNotFoundException("Resident not found with ID: " + paiementDTO.getResidentId()));

        Paiement paiement = PaiementMapper.toEntity(paiementDTO, resident);
        paiement.setStatu("Payer");
        paiement.setDateLimite(LocalDate.now().plusMonths(1)); // Example due date

        Paiement savedPaiement = PaiementRepository.save(paiement);
        return PaiementMapper.toDto(savedPaiement);
    }
}
