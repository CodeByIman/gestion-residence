package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;
import net.javaguides.gestion_residence.mapper.ChambreMapper;
import net.javaguides.gestion_residence.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;



//
//    @GetMapping
//    public List<Chambre> getAllChambres() {
//        return chambreService.getAllChambres();
//    }
//
//    @GetMapping("/available")
//    public List<Chambre> getAvailableChambres() {
//        return chambreService.getAvailableChambres();
//    }

    @PostMapping("/create")
    public ResponseEntity<ChambreDto> createChambre(@RequestBody ChambreDto chambredto) {

        ChambreDto createdchambre= chambreService.saveChambre(chambredto);
        return new ResponseEntity<>(createdchambre, HttpStatus.CREATED);
    }

//
//    @DeleteMapping("/{id}")
//    public void deleteChambre(@PathVariable Long id) {
//        chambreService.deleteChambre(id);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreDto> getChambre(@PathVariable Long idd) {
        try {
            ChambreDto chambreDto = chambreService.getChambre(idd);
            return new ResponseEntity<>(chambreDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<ChambreDto>> getAllChambres() {
        List<ChambreDto> chambres = chambreService.getAllChambres();
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }
    // Get available Chambres
    @GetMapping("/available")
    public ResponseEntity<List<ChambreDto>> getAvailableChambres() {
        List<ChambreDto> chambres = chambreService.getAvailableChambres();
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChambreDto> updateChambre(@PathVariable Long id, @RequestBody ChambreDto chambreDto) {
        try {
            ChambreDto updatedChambreDto = chambreService.updateChambre(id, chambreDto);
            return new ResponseEntity<>(updatedChambreDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChambre(@PathVariable Long id) {
        try {
            chambreService.deleteChambre(id);
            return new ResponseEntity<>("Chambre supprimée avec succès", HttpStatus.NO_CONTENT);  // Status 204 - No Content
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Chambre non trouvée", HttpStatus.NOT_FOUND);  // Status 404 - Not Found
        }
    }



    @PutMapping("/assign/{chambreId}")

    public ResponseEntity<String> assignResidentToChambre(@PathVariable long chambreId, @RequestBody Map<String, Long> request) {
        Long residentId = request.get("residentId");
        chambreService.assignResidentToChambre(chambreId, residentId);  // Appel du service avec les IDs
        return ResponseEntity.ok("Resident assigned successfully.");
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getChambreStatistics() {
        Map<String, Object> stats = chambreService.getChambreStatistics();
        return ResponseEntity.ok(stats);
    }

}
