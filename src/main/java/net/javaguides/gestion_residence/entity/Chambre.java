package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import net.javaguides.gestion_residence.dto.ChambreDto;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String taille;

    private String equipements;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Status", nullable = false)
    private Status status;

    public enum Status {
        DISPONIBLE,
        OCCUPEE,
        MAINTENANCE
    }




    @ManyToOne
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    private Resident resident;

    // Getters manuels
    public Long getId() {
        return id;
    }

    public String getTaille() {
        return taille;
    }

    public String getEquipements() {
        return equipements;
    }

    // Getter et Setter pour status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public Resident getResident() {
        return resident;
    }

    // Setters (si nécessaire)
    public void setId(Long id) {
        this.id = id;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }





    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
