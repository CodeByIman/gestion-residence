package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.PaiementRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.javaguides.gestion_residence.dto.PaiementDto;
import net.javaguides.gestion_residence.entity.Paiement;
import net.javaguides.gestion_residence.mapper.PaiementMapper;
import net.javaguides.gestion_residence.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")



@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;
    @GetMapping
    public ResponseEntity<List<PaiementDto>> getAllPaiements() {
        List<PaiementDto> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    @GetMapping("/resident/{residentId}")
    public ResponseEntity<List<PaiementDto>> getPaiementsByResidentId(@PathVariable Long residentId) {
        List<PaiementDto> paiements = paiementService.getPaiementsByResidentId(residentId);
        return ResponseEntity.ok(paiements);
    }

    @PostMapping("/add")
    public ResponseEntity<PaiementDto> addPaiement(@RequestBody PaiementDto paiementDto) {
        PaiementDto newPaiement = paiementService.addPaiement(paiementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaiement);
    }

}

