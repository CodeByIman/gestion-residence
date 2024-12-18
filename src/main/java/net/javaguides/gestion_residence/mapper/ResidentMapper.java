package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.ResidentDto;
import net.javaguides.gestion_residence.entity.Resident;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResidentMapper {
    ResidentMapper INSTANCE = Mappers.getMapper(ResidentMapper.class);

    ResidentDto toDto(Resident resident); // Entity to DTO
    Resident toEntity(ResidentDto residentDto); // DTO to Entity
}
