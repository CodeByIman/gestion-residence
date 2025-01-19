


package net.javaguides.gestion_residence.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.dto.TechnicienDto;
import net.javaguides.gestion_residence.entity.Technicien;
import net.javaguides.gestion_residence.service.ResidentService;
import net.javaguides.gestion_residence.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import net.javaguides.gestion_residence.dto.LoginRequest;
import net.javaguides.gestion_residence.entity.Technicien;
import net.javaguides.gestion_residence.service.TechnicienService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/techniciens")
@RequiredArgsConstructor
public class TechnicienController {

    @Autowired
    private TechnicienService technicienService;


    @PostMapping("/add")
    public ResponseEntity<TechnicienDto> addTechnicien(@RequestBody TechnicienDto technicienDto) {
        TechnicienDto savedTechnicien = technicienService.addTechnicien(technicienDto);
        return ResponseEntity.ok(savedTechnicien);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TechnicienDto>> getAllTechniciens() {
        List<TechnicienDto> techniciens = technicienService.getAllTechniciens();
        return ResponseEntity.ok(techniciens);
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        TechnicienDto technicienDto = technicienService.loginTechnicien(loginRequest.getEmail(), loginRequest.getPassword());
        if (technicienDto != null) {
            return ResponseEntity.ok(technicienDto);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
