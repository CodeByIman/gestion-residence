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
        ChambreDto chambreDto = new ChambreDto();
        chambreDto.setId(chambre.getId());
        chambreDto.setTaille(chambre.getTaille());
        chambreDto.setEquipements(chambre.getEquipements());

        // Map Chambre.Status to ChambreDto.Status if not null
        if (chambre.getStatus() != null) {
            chambreDto.setStatus(ChambreDto.Status.valueOf(chambre.getStatus().name()));
        }
        return chambreDto;
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

        // Gérer le statut avec une valeur par défaut
        if (chambreDto.getStatus() != null) {
            chambre.setStatus(Chambre.Status.valueOf(chambreDto.getStatus().name()));
        } else {
            chambre.setStatus(Chambre.Status.DISPONIBLE); // Définir DISPONIBLE par défaut
        }

        return chambre;
    }


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



    public static List<ChambreDto> mapToChambreDTOList(List<Chambre> chambres) {
        return chambres.stream()
                .map(ChambreMapper::mapToChambreDTO)
                .collect(Collectors.toList());
    }
}
