
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
    private Long idTechnicien;
    private String nomTechnicien;
    private String specialite;

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

    public Long getIdTechnicien() {
        return idTechnicien;
    }

    public void setIdTechnicien(Long idTechnicien) {
        this.idTechnicien = idTechnicien;
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
