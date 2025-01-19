package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.IncidentDto;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
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
    public ResponseEntity<?> assignIncidentToTechnicien(
            @PathVariable Long incidentId,
            @PathVariable Long technicienId) {
        // Check if technicienId is null
        if (technicienId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Technicien ID ne peut pas être nul.");
        }

        try {
            // Attempt to assign the incident to the technician
            IncidentDto updatedIncident = incidentService.assignIncidentToTechnicien(incidentId, technicienId);
            return ResponseEntity.ok(updatedIncident);
        } catch (RessourceNotFoundException e) {
            // Handle case where the incident or technician is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur interne est survenue lors de l'assignation de l'incident.");
        }
    }


    // Endpoint pour récupérer tous les incidents
    @GetMapping
    public ResponseEntity<List<IncidentDto>> getAllIncidents() {
        List<IncidentDto> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }


    @GetMapping("/technicien/{technicienId}")
    public ResponseEntity<List<IncidentDto>> getIncidentsByTechnicienId(@PathVariable Long technicienId) {
        List<IncidentDto> incidents = incidentService.getIncidentsByTechnicienId(technicienId);
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

}

