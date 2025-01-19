

package net.javaguides.gestion_residence.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.gestion_residence.dto.TechnicienDto;
import net.javaguides.gestion_residence.entity.Technicien;
import net.javaguides.gestion_residence.mapper.ResidentMapper;
import net.javaguides.gestion_residence.mapper.TechnicienMapper;
import net.javaguides.gestion_residence.repository.ResidentRepository;
import net.javaguides.gestion_residence.repository.TechnicienRepository;
import net.javaguides.gestion_residence.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TechnicienServiceImpl implements TechnicienService {

    @Autowired
    private  TechnicienRepository technicienRepository;
    @Override
    public TechnicienDto addTechnicien(TechnicienDto technicienDto) {
        Technicien technicien = TechnicienMapper.toEntity(technicienDto);
        Technicien savedTechnicien = technicienRepository.save(technicien);
        return TechnicienMapper.toDto(savedTechnicien);
    }

    @Override
    public List<TechnicienDto> getAllTechniciens() {
        return technicienRepository.findAll()
                .stream()
                .map(TechnicienMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TechnicienDto loginTechnicien(String email, String password) {
        Technicien technicien = technicienRepository.findByEmailAndPassword(email, password);

        if (technicien != null && technicien.getPassword().equals(password)) {
            return TechnicienMapper.toDto(technicien); // Assurez-vous d'avoir un mapper pour convertir l'entité en DTO
        }
        return null;
    }
}

