package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Mappers.SpecializationMapper;
import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Spec")
@Validated // Enables validation on method parameters
@CrossOrigin(origins = "http://localhost:4200")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private SpecializationMapper specializationMapper;

    // Get all specializations
    @GetMapping
    public List<SpecializationDTO> getSpecializations() {
        // Convert list of Specialization entities to SpecializationDTOs
        return specializationService.getSpecializations().stream()
                .map(specializationMapper::toDto)
                .collect(Collectors.toList());
    }

    // Add a new specialization
    @PostMapping
    public Specialization addSpecializations(@Valid @RequestBody Specialization specialization) {
        // Save the new specialization and return it
        return specializationService.addSpecializations(specialization);
    }

    // Delete a specialization by ID
    @DeleteMapping("/{specializationId}")
    public void deleteSpecialization(@PathVariable("specializationId") long specializationId) {
        // Delete the specialization by its ID
        specializationService.deleteSpecializationById(specializationId);
    }

    // Update an existing specialization
    @PutMapping("/{specializationId}")
    public boolean updateSpecialization(
            @PathVariable("specializationId") long specializationId,
            @Valid @RequestBody SpecializationDTO specializationDTO) {
        // Update the specialization and return the result as a boolean
        return specializationService.updateSpecialization(specializationId, specializationDTO.getName());
    }
}
