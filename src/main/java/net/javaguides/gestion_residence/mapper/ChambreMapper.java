package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.entity.Residence;
import net.javaguides.gestion_residence.entity.Resident;

import java.util.List;
import java.util.stream.Collectors;


public class ChambreMapper {

    // Mapper : Chambre -> ChambreDTO
    public static ChambreDto mapToChambreDTO(Chambre chambre) {
        return new ChambreDto(
                chambre.getId(),
                chambre.getTaille(),
                chambre.getEquipements(),
                chambre.isDisponible(),
                chambre.getResidence() != null ? chambre.getResidence().getId() : null,
                chambre.getResident() != null ? chambre.getResident().getIdResid() : null

        );
    }

//    // Mapper : ChambreDTO -> Chambre
//    public static Chambre mapToChambre(ChambreDto chambreDto) {
//        Chambre chambre = new Chambre();
//        chambre.setId(chambreDto.getId());
//
//        chambre.setTaille(chambreDto.getTaille());
//        chambre.setEquipements(chambreDto.getEquipements());
//
//        // Forcer le statut à DISPONIBLE par défaut
//        chambre.setDisponible(chambreDto.isDisponible());
//        chambre.getResidence().setId(chambreDto.getResidenceId());
//        chambre.getResident().setIdResid(chambreDto.getResidentId());
//
//        return chambre;
//    }
public static Chambre mapToChambre(ChambreDto chambreDto) {
    Chambre chambre = new Chambre();
    chambre.setId(chambreDto.getId());
    chambre.setTaille(chambreDto.getTaille());
    chambre.setEquipements(chambreDto.getEquipements());
    chambre.setDisponible(chambreDto.isDisponible());

    //remove commentaire au dessous si tua besoin dettribuer a la chambre une residenc eet un chambre apresavoire verifier quil exist deja un resident qi a ce id pour ne pas avoire exeption

//    // Initialiser la résidence si l'ID est non nul
//    if (chambreDto.getResidenceId() != null) {
//        Residence residence = new Residence();
//        residence.setId(chambreDto.getResidenceId());
//        chambre.setResidence(residence); // Associer la résidence à la chambre
//    }
//
//    // Initialiser le résident si l'ID est non nul
//    if (chambreDto.getResidentId() != null) {
//        Resident resident = new Resident();
//        resident.setIdResid(chambreDto.getResidentId());
//        chambre.setResident(resident); // Associer le résident à la chambre
//    }

    return chambre;
}

    public static List<ChambreDto> mapToChambreDTOList(List<Chambre> chambres) {
        return chambres.stream()
                .map(ChambreMapper::mapToChambreDTO)
                .collect(Collectors.toList());
    }
}
