package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.LoginRequest;
import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.mapper.ResidentMapper;
import net.javaguides.gestion_residence.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PostMapping("/create")
    public ResponseEntity<ResidentDto> createResident(@RequestBody ResidentDto residentDto) {
        ResidentDto createdResident = residentService.saveResident(residentDto);
        return new ResponseEntity<>(createdResident, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidentDto> getResidentById(@PathVariable Long id) {
        try {
            ResidentDto resident = residentService.getResident(id);
            return new ResponseEntity<>(resident, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ResidentDto>> getAllResidents() {
        List<ResidentDto> residents = residentService.getAllResidents();
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResidentDto> updateResident(
            @PathVariable Long id,
            @RequestBody ResidentDto residentDto
    ) {
        try {
            ResidentDto updatedResident = residentService.updateResident(id, residentDto);
            return new ResponseEntity<>(updatedResident, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable Long id) {
        try {
            residentService.deleteResident(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//     Nouvelle méthode pour récupérer les résidents par ID de chambre
@GetMapping("/chambre/{chambreId}")
public ResponseEntity<List<ResidentDto>> getResidentsByChambreId(@PathVariable Long chambreId) {
    try {
        List<ResidentDto> residents = residentService.getResidentsByChambreId(chambreId); // Nécessite l'ajout dans le service.
        return new ResponseEntity<>(residents, HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



    @GetMapping("/without-chambre")
    public List<Resident> getResidentsWithoutChambre() {
        return residentService.findResidentsWithoutChambre();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        ResidentDto residentDto = residentService.authenticateResident(loginRequest.getEmail(), loginRequest.getPassword());
        if (residentDto != null) {
            return ResponseEntity.ok(residentDto);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }


}

