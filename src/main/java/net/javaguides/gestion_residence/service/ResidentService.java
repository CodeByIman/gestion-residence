package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.entity.Resident;

import java.util.List;


public interface ResidentService {




    ResidentDto saveResident(ResidentDto residentDto);
    ResidentDto updateResident(Long id, ResidentDto residentDto);
    ResidentDto getResident(Long id);
    List<ResidentDto> getAllResidents();
    void deleteResident(Long id);


    List<ResidentDto> getResidentsByChambreId(Long chambreId);
    List<Resident> findResidentsWithoutChambre();
    ResidentDto authenticateResident(String email, String password);
}
