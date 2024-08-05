package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.AppointmentDTO;
import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.Models.Appointment;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Patient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentMapper {
    public AppointmentDTO toDto(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatientID(appointment.getPatient() != null ? appointment.getPatient().getId() : null);
        dto.setDoctorID(appointment.getDoctor() != null ? appointment.getDoctor().getId() : null);
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setReason(appointment.getReason());
        return dto;
    }

}
