
package net.javaguides.gestion_residence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;


@Entity
@Table(name = "techniciens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Technicien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomTechnicien;
    private String specialite;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNomTechnicien() {
        return nomTechnicien;
    }

    public void setNomTechnicien(String nomTechnicien) {
        this.nomTechnicien = nomTechnicien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idTechnicien) {
        this.id = idTechnicien;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    @OneToMany(mappedBy = "technicien", cascade = CascadeType.ALL)
    private List<Incident> incidents;
}
