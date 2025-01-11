package net.javaguides.gestion_residence.mapper;


import net.javaguides.gestion_residence.dto.IncidentDto;
import net.javaguides.gestion_residence.entity.Incident;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.entity.Technicien;
import java.util.List;
import java.util.stream.Collectors;

public class IncidentMapper {

    // Convert Incident entity to IncidentDto
    public static IncidentDto toDto(Incident incident) {
        return new IncidentDto(
                incident.getId(),
                incident.getTypeIncident(),
                incident.getStatut(),
                incident.getDescription(),
                incident.getTechnicien() != null ? incident.getTechnicien().getIdTechnicien() : null,
                incident.getResident() != null ? incident.getResident().getId() : null
        );
    }

    // Convert IncidentDto to Incident entity
    public static Incident toEntity(IncidentDto incidentDto, Technicien technicien, Resident resident) {
        Incident incident = new Incident();
        incident.setId(incidentDto.getId());
        incident.setTypeIncident(incidentDto.getTypeIncident());
        incident.setStatut(incidentDto.getStatut());
        incident.setDescription(incidentDto.getDescription());
        incident.setTechnicien(technicien);
        incident.setResident(resident);
        return incident;
    }
}
