package net.javaguides.gestion_residence.dto;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class ChambreDto {

    private Long id;
    private String taille;
    private String equipements;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public enum Status {
        DISPONIBLE,
        OCCUPEE,
        MAINTENANCE
    }
    private Long residenceId; // Identifiant de la résidence
    private Long residentId;

    // Constructeur sans argument
    public ChambreDto() {
    }

    // Constructeur avec arguments
    public ChambreDto(Long id, String taille, String equipements, Status status, Long residenceId, Long residentId) {
        this.id = id;
        this.taille = taille;
        this.equipements = equipements;
        this.status = status;
        this.residenceId = residenceId;
        this.residentId = residentId;
    }

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour taille
    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    // Getter et Setter pour equipements
    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    // Getter et Setter pour status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter et Setter pour residenceId
    public Long getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(Long residenceId) {
        this.residenceId = residenceId;
    }

    // Getter et Setter pour residentId
    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }
}
