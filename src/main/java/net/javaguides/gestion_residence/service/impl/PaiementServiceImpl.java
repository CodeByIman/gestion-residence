package net.javaguides.gestion_residence.service.impl;

import net.javaguides.gestion_residence.dto.PaiementDto;
import net.javaguides.gestion_residence.entity.Paiement;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.exception.RessourceNotFoundException;
import net.javaguides.gestion_residence.mapper.PaiementMapper;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.repository.PaiementRepository;
import net.javaguides.gestion_residence.service.PaiementService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class PaiementServiceImpl  implements PaiementService {

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private PaiementRepository PaiementRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public List<PaiementDto> getAllPaiements() {
        List<Paiement> paiements = PaiementRepository.findAll();
        return paiements.stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaiementDto> getPaiementsByResidentId(Long residentId) {
        List<Paiement> paiements = PaiementRepository.findByResidentId(residentId);
        return paiements.stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override

    public PaiementDto addPaiement(PaiementDto paiementDTO) {
        Resident resident = residentRepository.findById(paiementDTO.getResidentId())
                .orElseThrow(() -> new RessourceNotFoundException("Resident not found with ID: " + paiementDTO.getResidentId()));

        Paiement paiement = PaiementMapper.toEntity(paiementDTO, resident);
        paiement.setStatu("Payer");
        paiement.setDateLimite(LocalDate.now().plusMonths(1)); // Example due date

        Paiement savedPaiement = PaiementRepository.save(paiement);
        return PaiementMapper.toDto(savedPaiement);
    }


    @Override
    public List<PaiementDto> checkAndUpdateLatePayments() {
        List<Paiement> paiements = PaiementRepository.findAll();
        List<Paiement> latePaiements = new ArrayList<>();

        for (Paiement paiement : paiements) {
            if (paiement.getDateLimite().isBefore(LocalDate.now()) && !paiement.getStatu().equalsIgnoreCase("Non Payer")) {
                paiement.setStatu("Non Payer"); // Mettre à jour le statut
                PaiementRepository.save(paiement); // Sauvegarder la modification
                latePaiements.add(paiement);
            }
        }

        return latePaiements.stream()
                .map(PaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    //recuperer tous ls paiment en reatard

    //paiemant en retard email
    @Override
    // for test u can use this to dens the reatrd email evry after 2 min of the execution @Scheduled(fixedDelay = 120000)
    @Scheduled(cron = "0 0 1 * * ?")  //this send email every first month to the resident whi have paient with statu non payer
    public void checkAndNotifyLatePayments() {
        List<Paiement> paiements = PaiementRepository.findAll();

        for (Paiement paiement : paiements) {
            // Check if the payment is late and the status is not "Payer"
            if (paiement.getDateLimite().isBefore(LocalDate.now()) && !paiement.getStatu().equalsIgnoreCase("Payer")) {
                try {
                    sendLatePaymentEmail(paiement);
                } catch (MessagingException e) {
                    System.out.println("Failed to send late payment email for Resident ID " + paiement.getResident().getId() + ": " + e.getMessage());

                }
            }
        }
    }


    @Override
    public void sendLatePaymentEmail(Paiement paiement) throws MessagingException {
        Resident resident = paiement.getResident(); // Get the resident associated with this payment

        if (resident != null && resident.getEmail() != null) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(resident.getEmail());
            helper.setSubject("Rappel de paiement en retard");

            // Email content with HTML styling
            String emailContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif; color: #333;'>" +
                    "<h2 style='color: #2E86C1;'>Bonjour cher Résident,</h2>" +
                    "<p>Nous espérons que vous allez bien.</p>" +
                    "<p>Nous vous informons que nous n'avons pas encore reçu le paiement de votre loyer pour le mois de <strong>" + paiement.getDateLimite().getMonth() + "</strong>, dont la date d'échéance était fixée au <strong>" + paiement.getDateLimite() + "</strong>.</p>" +
                    "<h3 style='color: #C0392B;'>Détails du paiement en retard :</h3>" +
                    "<ul>" +
                    "<li><strong>Montant dû :</strong> <span style='color: #C0392B;'>" + paiement.getMontant() + " DH</span></li>" +
                    "</ul>" +
                    "<p>Afin d'éviter des pénalités de retard, nous vous invitons à régulariser votre situation dans les plus brefs délais.</p>" +
                    "<p>Modes de paiement acceptés : virement bancaire, chèque, etc.</p>" +
                    "<p style='font-style: italic;'>Si vous avez déjà réglé ce montant, merci de ne pas tenir compte de ce message.</p>" +
                    "<p>Pour toute difficulté financière ou question, n'hésitez pas à nous contacter.</p>" +
                    "<br>" +
                    "<p>Cordialement,<br><strong>L'équipe de gestion</strong></p>" +
                    "</body></html>";

            helper.setText(emailContent, true); // Enable HTML content

            mailSender.send(message); // Send the styled email
        } else {
            System.out.println("Resident with ID " + paiement.getResident().getId() + " does not have an email.");
        }
    }


    @Override
    public void sendTestEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Test Email");
        message.setText("Hello! This is a test email from your Spring Boot application.");

        mailSender.send(message);
    }

}
