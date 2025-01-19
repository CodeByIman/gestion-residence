package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.TechnicienDto;
import net.javaguides.gestion_residence.entity.Technicien;

public class TechnicienMapper {

    // Maps a Technicien entity to a TechnicienDto
    public static TechnicienDto toDto(Technicien technicien) {
        if (technicien == null) {
            return null;
        }

        TechnicienDto dto = new TechnicienDto();
        dto.setIdTechnicien(technicien.getId());
        dto.setNomTechnicien(technicien.getNomTechnicien());
        dto.setSpecialite(technicien.getSpecialite());
        dto.setEmail(technicien.getEmail());
        dto.setPassword(technicien.getPassword());
        // Map other fields as necessary
        return dto;
    }

    // Maps a TechnicienDto to a Technicien entity
    public static Technicien toEntity(TechnicienDto dto) {
        if (dto == null) {
            return null;
        }

        Technicien technicien = new Technicien();
        technicien.setId(dto.getIdTechnicien());
        technicien.setNomTechnicien(dto.getNomTechnicien());
        technicien.setSpecialite(dto.getSpecialite());
        technicien.setEmail(dto.getEmail());
        technicien.setPassword(dto.getPassword());
        // Map other fields as necessary
        return technicien;
    }
}
