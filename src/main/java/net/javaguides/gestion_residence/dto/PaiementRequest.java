package net.javaguides.gestion_residence.dto;

public class PaiementRequest {
    private Long residentId;
    private double montant;

    // Getters and setters
    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
