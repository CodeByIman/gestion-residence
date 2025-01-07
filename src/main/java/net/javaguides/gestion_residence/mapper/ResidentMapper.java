package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.entity.Residence;
import net.javaguides.gestion_residence.entity.Resident;

import java.util.List;
import java.util.stream.Collectors;
public class ResidentMapper {

    // Convert Entity to DTO
    public static ResidentDto mapToDto(Resident resident) {
        if (resident == null) {
            return null;
        }

        ResidentDto residentDto = new ResidentDto();
        residentDto.setId(resident.getId());
        residentDto.setName(resident.getName());
        residentDto.setEmail(resident.getEmail());
        residentDto.setChambreId(resident.getChambreId());

//        residentDto.setPaiementId(resident.getPaiements().getId()); ((obtient list des id de tout les paiment je pense que ca na sert a rien // Optional: if relevant

        return residentDto;
    }

    // Convert DTO to Entity



    public static Resident mapToEntity(ResidentDto residentDto) {
        if (residentDto == null) {
            return null;
        }

        Resident resident = new Resident();
        resident.setId(residentDto.getId());
        resident.setName(residentDto.getName());
        resident.setEmail(residentDto.getEmail());
        resident.setChambreId(residentDto.getChambreId());

        // `incidentId` or other fields can be handled here if needed
        return resident;
    }
}
