package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.dto.TechnicienDto;

import java.util.List;

public interface TechnicienService {
    TechnicienDto addTechnicien(TechnicienDto technicienDto);

    List<TechnicienDto> getAllTechniciens();

    TechnicienDto loginTechnicien(String email, String password);
}
