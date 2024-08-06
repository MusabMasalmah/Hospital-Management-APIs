package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Models.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    SpecializationMapper INSTANCE = Mappers.getMapper(SpecializationMapper.class);

    SpecializationDTO toDto(Specialization specialization);
    Specialization toEntity(SpecializationDTO specializationDTO);
}
