package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.ResidentDto;

import java.util.List;


public interface ResidentService {




    ResidentDto saveResident(ResidentDto residentDto);
    ResidentDto updateResident(Long id, ResidentDto residentDto);
    ResidentDto getResident(Long id);
    List<ResidentDto> getAllResidents();
    void deleteResident(Long id);



}
