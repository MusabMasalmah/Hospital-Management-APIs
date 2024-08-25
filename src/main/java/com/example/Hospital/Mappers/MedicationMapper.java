package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.MedicatoinDTO;
import com.example.Hospital.Models.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    Medication toEntity(MedicatoinDTO medicationDTO);

    MedicatoinDTO toDto(Medication medication);
}
