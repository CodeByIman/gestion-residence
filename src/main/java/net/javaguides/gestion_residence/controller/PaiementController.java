package net.javaguides.gestion_residence.controller;

import jakarta.mail.MessagingException;
import net.javaguides.gestion_residence.dto.PaiementRequest;
import net.javaguides.gestion_residence.repository.IncidentRepository;
import net.javaguides.gestion_residence.repository.PaiementRepository;
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
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")



@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;
    @Autowired
    private PaiementRepository paiementRepository;

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
    //test email reatard
    @GetMapping("/send-email")
    public String sendTestEmail(@RequestParam String email) {
        paiementService.sendTestEmail(email);
        return "Test email sent to " + email;
    }

    // Late payment email trigger
    @PostMapping("/send-late-payment-emails")
    public String sendLatePaymentEmails() {
        paiementService.checkAndNotifyLatePayments();
        return "Late payment emails have been sent.";
    }

    //update and get
    // mettre à jour les paiements en retard et les récupérer
    @GetMapping("/update-late")
    public ResponseEntity<List<PaiementDto>> updateAndGetLatePayments() {
        List<PaiementDto> latePayments = paiementService.checkAndUpdateLatePayments();
        return ResponseEntity.ok(latePayments);
    }

}

