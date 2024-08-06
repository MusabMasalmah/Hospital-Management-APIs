package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.PatientDTO;
import com.example.Hospital.Mappers.PatientMapper;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Patient")
@Validated // Enables validation on method parameters
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    /**
     * Retrieves a list of all patients.
     * @return A list of PatientDTOs representing all patients.
     */
    @GetMapping
    public List<PatientDTO> getPatients() {
        // Fetches all patients from the service, maps them to DTOs, and returns the list
        return patientService.getPatients().stream()
                .map(patientMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Adds a new patient.
     * @param p The Patient object to be added.
     * @return The added Patient object.
     */
    @PostMapping
    public Patient addPatient(@Valid @RequestBody Patient p) {
        // Adds a new patient using the service and returns the added patient
        return patientService.addPatient(p);
    }

    /**
     * Assigns a medication to a patient.
     * @param medId The ID of the medication.
     * @param patId The ID of the patient.
     * @return A boolean indicating if the assignment was successful.
     */
    @PostMapping("/med/{medId}/to/{patId}")
    public boolean assignMedToPatient(@PathVariable("medId") long medId, @PathVariable("patId") long patId) {
        // Assigns the medication to the patient and returns the result
        return patientService.assignMedToPatient(medId, patId);
    }

    /**
     * Assigns a patient to a doctor.
     * @param patId The ID of the patient.
     * @param docId The ID of the doctor.
     * @return A boolean indicating if the assignment was successful.
     */
    @PostMapping("/patient/{patId}/to/{docId}")
    public boolean assignPatientToDoctor(@PathVariable("patId") long patId, @PathVariable("docId") long docId) {
        // Assigns the patient to the doctor and returns the result
        return patientService.assignPatientToDoctor(patId, docId);
    }

    /**
     * Deletes a patient by their ID.
     * @param patientId The ID of the patient to be deleted.
     */
    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable("patientId") long patientId) {
        // Deletes the patient using the service
        patientService.deletePatientById(patientId);
    }

    /**
     * Updates an existing patient.
     * @param patientId The ID of the patient to update.
     * @param updatedPatient The updated Patient object.
     * @return The updated Patient object.
     */
    @PutMapping("/{patientId}")
    public boolean updatePatient(@PathVariable("patientId") long patientId, @Valid @RequestBody Patient updatedPatient) {
        // Updates the patient using the service and returns the updated patient
        return patientService.updatePatient(patientId, updatedPatient);
    }
}
