package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.MedicatoinDTO;
import com.example.Hospital.Mappers.MedicationMapper;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Med")
@Validated // Enables validation on method parameters
public class MedicationController {

    @Autowired
    private MedicationService medicationService; // Service for business logic

    @Autowired
    private MedicationMapper medicationMapper; // Mapper for converting between DTOs and entities

    /**
     * Retrieves a list of all medications.
     * @return List of MedicationDTO
     */
    @GetMapping
    public List<MedicatoinDTO> getMedications() {
        // Fetch medications from service and map them to DTOs
        return medicationService.getMedications().stream()
                .map(medicationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Adds a new medication.
     * @param medicationDTO DTO containing medication data
     * @return ResponseEntity with created Medication and HTTP status
     */
    @PostMapping
    public ResponseEntity<Medication> addMedication(@Valid @RequestBody MedicatoinDTO medicationDTO) {
        // Convert DTO to entity
        Medication medication = medicationMapper.toEntity(medicationDTO);
        // Add medication via service
        Medication createdMedication = medicationService.addMedication(medication);
        // Return created medication with HTTP 201 Created status
        return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
    }

    /**
     * Deletes a medication by its ID.
     * @param medicationId ID of the medication to be deleted
     * @return ResponseEntity with HTTP status
     */
    @DeleteMapping("/{medicationId}")
    public ResponseEntity<Void> deleteMedication(@PathVariable("medicationId") long medicationId) {
        // Delete medication via service
        medicationService.deleteMedicationById(medicationId);
        // Return HTTP 204 No Content status
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Updates an existing medication.
     * @param medicationId ID of the medication to be updated
     * @param medicationDTO DTO containing updated medication data
     * @return ResponseEntity with updated Medication and HTTP status
     */
    @PutMapping("/{medicationId}")
    public ResponseEntity<Medication> updateMedication(
            @PathVariable("medicationId") long medicationId,
            @Valid @RequestBody MedicatoinDTO medicationDTO) {
        Medication updatedMedication = medicationMapper.toEntity(medicationDTO);
        Medication medication = medicationService.updateMedication(medicationId, updatedMedication);
        return new ResponseEntity<>(medication, HttpStatus.OK);
    }
}
