//package net.javaguides.gestion_residence.service.impl;
//
//import net.javaguides.gestion_residence.dto.ResidentDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//public class ResidentServiceImpl {
//    ResidentDto saveResident(ResidentDto residentDto){
//        return residentDto;
//    }
//    public ResponseEntity<ResidentDto> getResident( @PathVariable Long id){
//
//            try {
//                ResidentDto ResidentDto = chambreService.getChambre(idd);
//                return new ResponseEntity<>(ResidentDto, HttpStatus.OK);
//            } catch (RuntimeException e) {
//                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//            }
//        }
//    }
//    List<ResidentDto> getAllResident(){}
//    ResidentDto updateResident(Long id, ResidentDto residentDto){}
//    void deleteResident(Long id){}
//}













package net.javaguides.gestion_residence.service.impl;


import lombok.AllArgsConstructor;
import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.entity.Resident;
import net.javaguides.gestion_residence.repository.ChambreRepository;
import net.javaguides.gestion_residence.repository.ResidenceRepository;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import net.javaguides.gestion_residence.mapper.ResidentMapper;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentRepository residentRepository;


    @Override
    public ResidentDto saveResident(ResidentDto residentDto) {
        Resident resident = ResidentMapper.mapToEntity(residentDto);
        Resident savedResident = residentRepository.save(resident);
        return ResidentMapper.mapToDto(savedResident);
    }

    @Override
    public ResidentDto getResident(Long id) {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));
        return ResidentMapper.mapToDto(resident);
    }

    @Override
    public List<ResidentDto> getAllResidents() {
        return residentRepository.findAll().stream()
                .map(ResidentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResidentDto updateResident(Long id, ResidentDto residentDto) {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found with ID: " + id));
        resident.setName(residentDto.getName());
        resident.setEmail(residentDto.getEmail());
        Resident updatedResident = residentRepository.save(resident);
        return ResidentMapper.mapToDto(updatedResident);
    }

    @Override
    public void deleteResident(Long id) {
        if (!residentRepository.existsById(id)) {
            throw new RuntimeException("Resident not found with ID: " + id);
        }
        residentRepository.deleteById(id);
    }
    @Override
    public List<ResidentDto> getResidentsByChambreId(Long id) {
        List<Resident> residents = residentRepository.findByChambreId(id);  // Assurez-vous d’avoir une requête dans le repository.
        return residents.stream()
                .map(ResidentMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
