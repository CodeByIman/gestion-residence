//package net.javaguides.gestion_residence.mapper;
//
//import net.javaguides.gestion_residence.dto.ChambreDto;
//import net.javaguides.gestion_residence.entity.Chambre;
//import net.javaguides.gestion_residence.entity.Residence;
//import net.javaguides.gestion_residence.entity.Resident;
//
//import java.util.List;
//import java.util.stream.Collectors;
//

package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;
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

        // Utilise l'ID du résident uniquement dans le DTO
        if (chambre.getResident() != null) {
            chambreDto.setResidentId(chambre.getResident().getId());
        }

        // Mappe le statut si non null
        if (chambre.getStatus() != null) {
            chambreDto.setStatus(ChambreDto.Status.valueOf(chambre.getStatus().name()));
        }
        return chambreDto;
    }

    // Mapper : ChambreDTO -> Chambre
    public static Chambre mapToChambre(ChambreDto chambreDto, Resident resident) {
        Chambre chambre = new Chambre();
        chambre.setId(chambreDto.getId());
        chambre.setTaille(chambreDto.getTaille());
        chambre.setEquipements(chambreDto.getEquipements());

        // Associe l'objet résident à partir du service ou du contrôleur
        chambre.setResident(resident);

        // Gère le statut avec une valeur par défaut si nécessaire
        if (chambreDto.getStatus() != null) {
            chambre.setStatus(Chambre.Status.valueOf(chambreDto.getStatus().name()));
        } else {
            chambre.setStatus(Chambre.Status.DISPONIBLE); // Valeur par défaut
        }

        return chambre;
    }

    // Mapper liste de Chambre -> liste de ChambreDTO
    public static List<ChambreDto> mapToChambreDTOList(List<Chambre> chambres) {
        return chambres.stream()
                .map(ChambreMapper::mapToChambreDTO)
                .collect(Collectors.toList());
    }
}

//
//public class ChambreMapper {
//
//    // Mapper : Chambre -> ChambreDTO
//    public static ChambreDto mapToChambreDTO(Chambre chambre) {
//        ChambreDto chambreDto = new ChambreDto();
//        chambreDto.setId(chambre.getId());
//        chambreDto.setTaille(chambre.getTaille());
//        chambreDto.setEquipements(chambre.getEquipements());
//
//        chambreDto.setResident(chambre.getResident());
//
//        // Map Chambre.Status to ChambreDto.Status if not null
//        if (chambre.getStatus() != null) {
//            chambreDto.setStatus(ChambreDto.Status.valueOf(chambre.getStatus().name()));
//        }
//        return chambreDto;
//    }
//
//
//
//
//
//
//    public static Chambre mapToChambre(ChambreDto chambreDto) {
//        Chambre chambre = new Chambre();
//        chambre.setId(chambreDto.getId());
//        chambre.setTaille(chambreDto.getTaille());
//        chambre.setEquipements(chambreDto.getEquipements());
//
//        chambre.setResident(chambreDto.getResident());
//
//        // Gérer le statut avec une valeur par défaut
//        if (chambreDto.getStatus() != null) {
//            chambre.setStatus(Chambre.Status.valueOf(chambreDto.getStatus().name()));
//        } else {
//            chambre.setStatus(Chambre.Status.DISPONIBLE); // Définir DISPONIBLE par défaut
//        }
//
//        return chambre;
//    }
//
//
//
//
//
//    public static List<ChambreDto> mapToChambreDTOList(List<Chambre> chambres) {
//        return chambres.stream()
//                .map(ChambreMapper::mapToChambreDTO)
//                .collect(Collectors.toList());
//    }
//}
