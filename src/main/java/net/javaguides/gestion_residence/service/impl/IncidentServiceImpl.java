package net.javaguides.gestion_residence.service.impl;

import net.javaguides.gestion_residence.dto.IncidentDto;
import net.javaguides.gestion_residence.entity.Incident;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.entity.Technicien;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
import net.javaguides.gestion_residence.mapper.IncidentMapper;
import net.javaguides.gestion_residence.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.gestion_residence.service.IncidentService;
import net.javaguides.gestion_residence.repository.ChambreRepository;
import net.javaguides.gestion_residence.repository.TechnicienRepository;
import net.javaguides.gestion_residence.repository.ResidentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService{

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private TechnicienRepository technicienRepository;

    @Autowired
    private ResidentRepository residentRepository;


    @Override
    public IncidentDto addIncident(IncidentDto incidentDto) {
        Resident resident = residentRepository.findById(incidentDto.getResidentId())
                .orElseThrow(() -> new RessourceNotFoundException("Resident not found with ID: " + incidentDto.getResidentId()));

        Technicien technicien = null;
        if (incidentDto.getTechnicienId() != null) {
            technicien = technicienRepository.findById(incidentDto.getTechnicienId())
                    .orElseThrow(() -> new RessourceNotFoundException("Technicien not found with ID: " + incidentDto.getTechnicienId()));
        }

        Incident incident = IncidentMapper.toEntity(incidentDto, technicien, resident);
        Incident savedIncident = incidentRepository.save(incident);
        return IncidentMapper.toDto(savedIncident);
    }

    // Attribuer un incident à un technicien
    public IncidentDto assignIncidentToTechnicien(Long incidentId, Long technicienId) {
        Incident incident = incidentRepository.findById(incidentId)
                .orElseThrow(() -> new RessourceNotFoundException("Incident not found with ID: " + incidentId));

        Technicien technicien = technicienRepository.findById(technicienId)
                .orElseThrow(() -> new RessourceNotFoundException("Technicien not found with ID: " + technicienId));

        incident.setTechnicien(technicien);
        Incident updatedIncident = incidentRepository.save(incident);
        return IncidentMapper.toDto(updatedIncident);
    }

    // Récupérer tous les incidents
    public List<IncidentDto> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        return incidents.stream()
                .map(IncidentMapper::toDto)
                .collect(Collectors.toList());
    }
}
