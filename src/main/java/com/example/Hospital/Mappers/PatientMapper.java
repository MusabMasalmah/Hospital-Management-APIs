package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.PatientDTO;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Repositoris.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {

    @Autowired
    DoctorRepo doctorRepository;
    public PatientDTO toDto(Patient patient) {
        if (patient == null) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());

        // Mapping Doctor entity to DoctorId
        if (patient.getDoctor() != null) {
            patientDTO.setDoctorId(patient.getDoctor().getId());
        }

        // Mapping Medications to MedicationIds
        if (patient.getMedications() != null) {
            List<Long> medicationIds = patient.getMedications()
                    .stream()
                    .map(Medication::getId)
                    .collect(Collectors.toList());
            patientDTO.setMedicationIds(medicationIds);
        }

        return patientDTO;
    }

    public Patient toEntity(PatientDTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());

        // Find and set the Doctor entity using the ID from DTO
        Doctor doctor = doctorRepository.findById(patientDTO.getDoctorId()).orElse(null);
        patient.setDoctor(doctor);


        return patient;
    }
}
