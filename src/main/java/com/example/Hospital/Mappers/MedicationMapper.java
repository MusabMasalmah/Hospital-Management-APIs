package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.MedicatoinDTO;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Patient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicationMapper {
    public MedicatoinDTO toDto(Medication medication) {
        MedicatoinDTO dto = new MedicatoinDTO();
        dto.setId(medication.getId());
        dto.setName(medication.getName());
        List<Long> patientIds = medication.getPatients() == null ?
                Collections.emptyList() :
                medication.getPatients().stream()
                        .map(Patient::getId)
                        .collect(Collectors.toList());

        dto.setPatientsIDs(patientIds);

        return dto;
    }
}
