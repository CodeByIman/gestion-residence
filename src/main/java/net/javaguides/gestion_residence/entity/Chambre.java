package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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

    private boolean disponible;

    @ManyToOne
    @JoinColumn
    private Residence residence;

    @ManyToOne
    @JoinColumn
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

    public boolean isDisponible() {
        return disponible;
    }

    public Residence getResidence() {
        return residence;
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
