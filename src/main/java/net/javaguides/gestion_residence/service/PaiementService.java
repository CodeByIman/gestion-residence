package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.PaiementDto;

import java.util.List;


import net.javaguides.gestion_residence.entity.Paiement;
import java.util.List;

public interface PaiementService {

    List<PaiementDto> getAllPaiements();
    List<PaiementDto> getPaiementsByResidentId(Long residentId);
    PaiementDto addPaiement(PaiementDto paiementDTO);
}
