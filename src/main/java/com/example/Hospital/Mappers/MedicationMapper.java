package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.MedicatoinDTO;
import com.example.Hospital.Models.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    MedicatoinDTO toDto(Medication medication);
    Medication toEntity(MedicatoinDTO medicationDTO);
}
