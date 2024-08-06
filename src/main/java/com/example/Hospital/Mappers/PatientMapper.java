package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.PatientDTO;
import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Specialization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDTO toDto(Patient patient);
    Patient toEntity(PatientDTO patientDTO);
}
