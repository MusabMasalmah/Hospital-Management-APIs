package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.DTOs.PatientDTO;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Patient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public PatientDTO toDto(Patient patient) {
        PatientDTO dto = new PatientDTO();
        dto.setId(patient.getId());
        dto.setName(patient.getName());

        // Handle null doctor
        if (patient.getDoctor() != null) {
            dto.setDoctorId(patient.getDoctor().getId());
        } else {
            dto.setDoctorId(-1L);
        }

        // Handle null medications list
        List<Long> medicationIds = patient.getMedications() == null ?
                Collections.emptyList() :
                patient.getMedications().stream()
                        .map(Medication::getId)
                        .collect(Collectors.toList());

        dto.setMedicationIds(medicationIds);
        return dto;
    }
}
