
package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "residents")

@NoArgsConstructor
@AllArgsConstructor
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResid;
    private String nomResid;
    private int ageResid;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<Chambre> chambres;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<Paiement> paiements;


    // Getter and Setter for idResid
    public Long getIdResid() {
        return idResid;
    }

    public void setIdResid(Long idResid) {
        this.idResid = idResid;
    }

    // Getter and Setter for nomResid
    public String getNomResid() {
        return nomResid;
    }

    public void setNomResid(String nomResid) {
        this.nomResid = nomResid;
    }

    // Getter and Setter for ageResid
    public int getAgeResid() {
        return ageResid;
    }

    public void setAgeResid(int ageResid) {
        this.ageResid = ageResid;
    }

    // Getter and Setter for chambres
    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }

    // Getter and Setter for paiements
    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }


}

