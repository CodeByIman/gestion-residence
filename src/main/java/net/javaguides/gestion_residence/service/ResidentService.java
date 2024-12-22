package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.dto.ResidentDto;

import java.util.List;

public interface ResidentService {

    ResidentDto saveResident(ResidentDto residentDto);
    ResidentDto getResident(Long id);
    List<ResidentDto> getAllResident();
    ResidentDto updateResident(Long id, ResidentDto residentDto);
    void deleteResident(Long id);
}
