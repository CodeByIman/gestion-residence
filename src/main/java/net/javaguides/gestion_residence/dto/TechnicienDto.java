package net.javaguides.gestion_residence.dto;

import lombok.Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnicienDto {
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

    public Long getIdTechnicien() {
        return id;
    }

    public void setIdTechnicien(Long idTechnicien) {
        this.id = idTechnicien;
    }

    public String getNomTechnicien() {
        return nomTechnicien;
    }

    public void setNomTechnicien(String nomTechnicien) {
        this.nomTechnicien = nomTechnicien;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
