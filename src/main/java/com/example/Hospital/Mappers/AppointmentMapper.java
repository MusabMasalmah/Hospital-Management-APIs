package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.AppointmentDTO;
import com.example.Hospital.Models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(source = "patient.id", target = "patientID")
    @Mapping(source = "doctor.id", target = "doctorID")
    AppointmentDTO toDto(Appointment appointment);

    Appointment toEntity(AppointmentDTO appointmentDTO);
}