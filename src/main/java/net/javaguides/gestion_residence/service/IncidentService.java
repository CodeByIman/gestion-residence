package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.IncidentDto;
import java.util.List;

public interface IncidentService {

    IncidentDto addIncident(IncidentDto incidentDto);

    IncidentDto assignIncidentToTechnicien(Long incidentId, Long technicienId);

    List<IncidentDto> getAllIncidents();
//
    List<IncidentDto> getIncidentsByTechnicienId(Long technicienId);
}
