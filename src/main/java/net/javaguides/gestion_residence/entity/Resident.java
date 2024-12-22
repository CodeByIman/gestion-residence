
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
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<Chambre> chambres;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<Paiement> paiements;


    // Getter and Setter for idResid
    public Long getId() {
        return id;
    }

    public void setId(Long idResid) {
        this.id = idResid;
    }

    // Getter and Setter for nomResid
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for ageResid
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

