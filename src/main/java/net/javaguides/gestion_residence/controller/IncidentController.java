package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.IncidentDto;
import net.javaguides.gestion_residence.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping("/add")
    public ResponseEntity<IncidentDto> addIncident(@RequestBody IncidentDto incidentDto) {
        IncidentDto newIncident = incidentService.addIncident(incidentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newIncident);
    }

    // Endpoint pour attribuer un incident à un technicien
    @PutMapping("/{incidentId}/assign/{technicienId}")
    public ResponseEntity<IncidentDto> assignIncidentToTechnicien(
            @PathVariable Long incidentId,
            @PathVariable Long technicienId) {
        IncidentDto updatedIncident = incidentService.assignIncidentToTechnicien(incidentId, technicienId);
        return new ResponseEntity<>(updatedIncident, HttpStatus.OK);
    }

    // Endpoint pour récupérer tous les incidents
    @GetMapping
    public ResponseEntity<List<IncidentDto>> getAllIncidents() {
        List<IncidentDto> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }
}

