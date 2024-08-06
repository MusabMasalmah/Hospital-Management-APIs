package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.AppointmentDTO;
import com.example.Hospital.Models.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    AppointmentDTO toDto(Appointment appointment);
    Appointment toEntity(AppointmentDTO appointmentDTO);
}
