package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "residences")
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double tauxOccupation;
    private double paiementRetard;
    private int incidentEnCours;
    private int capaciteHebergement;
    private int chambreDisponible;



    // Constructor without arguments
    public Residence() {
    }

    // Constructor with all arguments
    public Residence(Long id, double tauxOccupation, double paiementRetard, int incidentEnCours, int capaciteHebergement, int chambreDisponible, List<Chambre> chambres) {
        this.id = id;
        this.tauxOccupation = tauxOccupation;
        this.paiementRetard = paiementRetard;
        this.incidentEnCours = incidentEnCours;
        this.capaciteHebergement = capaciteHebergement;
        this.chambreDisponible = chambreDisponible;

    }

    // Getters
    public Long getId() {
        return id;
    }

    public double getTauxOccupation() {
        return tauxOccupation;
    }

    public double getPaiementRetard() {
        return paiementRetard;
    }

    public int getIncidentEnCours() {
        return incidentEnCours;
    }

    public int getCapaciteHebergement() {
        return capaciteHebergement;
    }

    public int getChambreDisponible() {
        return chambreDisponible;
    }



    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTauxOccupation(double tauxOccupation) {
        this.tauxOccupation = tauxOccupation;
    }

    public void setPaiementRetard(double paiementRetard) {
        this.paiementRetard = paiementRetard;
    }

    public void setIncidentEnCours(int incidentEnCours) {
        this.incidentEnCours = incidentEnCours;
    }

    public void setCapaciteHebergement(int capaciteHebergement) {
        this.capaciteHebergement = capaciteHebergement;
    }

    public void setChambreDisponible(int chambreDisponible) {
        this.chambreDisponible = chambreDisponible;
    }

}
