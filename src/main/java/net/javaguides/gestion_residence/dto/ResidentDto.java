package net.javaguides.gestion_residence.dto;

public class ResidentDto {
    private Long id;
    private String name;
    private String email;
    private Long incidentId; // Identifiant de la résidence
    private Long paiementId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public void setPaiementId(Long paiementId) {
        this.paiementId = paiementId;
    }
    public Long getPaiementId() {
        return paiementId;
    }


}
