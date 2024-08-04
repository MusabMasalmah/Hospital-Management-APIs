package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Specialization;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {
    public DoctorDTO toDto(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        if (doctor.getSpecialization() != null) {
            dto.setSpecializationID(doctor.getSpecialization().getId());
        } else {
            dto.setSpecializationID(-1); // Or any default value or handling logic you prefer
        }

        List<Long> patientIds = doctor.getPatients() == null ?
                Collections.emptyList() :
                doctor.getPatients().stream().map(Patient::getId).collect(Collectors.toList());

        dto.setPatientsIDs(patientIds);
        return dto;
    }
}
