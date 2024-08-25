package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.Mappers.DoctorMapper;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Doctor")
@Validated // Enables validation on method parameters
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * Retrieves a list of all doctors.
     * @return A list of DoctorDTOs representing all doctors.
     */
    @GetMapping
    public List<DoctorDTO> getDoctors() {
        // Fetches all doctors from the service, maps them to DTOs, and returns the list
        return doctorService.getDoctors().stream()
                .map(doctorMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/page")
    public Page<DoctorDTO> getDoctorsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> doctorPage = doctorService.getDoctorsByPage(pageable);
        return doctorPage.map(doctorMapper::toDto);
    }

    /**
     * Retrieves a doctor by their name.
     * @param name The name of the doctor to find.
     * @return The DoctorDTO representing the found doctor.
     */
    @GetMapping("/byName")
    public DoctorDTO getDoctorByName(@Valid @RequestBody String name) {
        // Finds a doctor by name using the service and maps it to a DTO
        Doctor doctor = doctorService.findDoctorByName(name);
        return doctorMapper.toDto(doctor);
    }

    /**
     * Adds a new doctor.
     * @param d The Doctor object to be added.
     * @return The added Doctor object.
     */
    @PostMapping
    public Doctor addDoctor(@Valid @RequestBody Doctor d) {
        // Adds a new doctor using the service and returns the added doctor
        return doctorService.addDoctor(d);
    }

    /**
     * Assigns a specialization to a doctor.
     * @param doctorId The ID of the doctor.
     * @param specId The ID of the specialization to assign.
     * @return A boolean indicating if the assignment was successful.
     */
    @PostMapping("{doctorId}/to/{specId}")
    public boolean assignSpecToDoctor(@PathVariable("doctorId") long doctorId, @PathVariable("specId") long specId) {
        // Assigns the specialization to the doctor and returns the result
        return doctorService.assignSpecToDoctor(doctorId, specId);
    }

    /**
     * Deletes a doctor by their ID.
     * @param doctorId The ID of the doctor to be deleted.
     */
    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") long doctorId) {
        // Deletes the doctor using the service
        doctorService.deleteDoctorById(doctorId);
    }

    /**
     * Updates an existing doctor.
     * @param doctorId The ID of the doctor to update.
     * @param newDoctor The updated Doctor object.
     * @return The updated Doctor object.
     */
    @PutMapping("/{doctorId}")
    public boolean updateDoctor(@PathVariable("doctorId") long doctorId, @Valid @RequestBody Doctor newDoctor) {
        // Updates the doctor using the service and returns the updated doctor
        return doctorService.updateDoctor(doctorId, newDoctor);
    }
}
