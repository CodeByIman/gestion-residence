package net.javaguides.gestion_residence.dto;


public class IncidentDto {
    private Long id;
    private String typeIncident;
    private String statut;
    private String description;
    private Long technicienId;
    private Long residentId;

    // Constructors
    public IncidentDto() {}

    public IncidentDto(Long id, String typeIncident, String statut, String description, Long technicienId, Long residentId) {
        this.id = id;
        this.typeIncident = typeIncident;
        this.statut = statut;
        this.description = description;
        this.technicienId = technicienId;
        this.residentId = residentId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeIncident() {
        return typeIncident;
    }

    public void setTypeIncident(String typeIncident) {
        this.typeIncident = typeIncident;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(Long technicienId) {
        this.technicienId = technicienId;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }
}
