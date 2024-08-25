package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.Models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "specialization.id", target = "specializationID")
    DoctorDTO toDto(Doctor doctor);

    Doctor toEntity(DoctorDTO doctorDTO);
}
