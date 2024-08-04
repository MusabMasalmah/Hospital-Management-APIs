package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.MedicatoinDTO;
import com.example.Hospital.Mappers.MedicationMapper;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Repositoris.MediciationRepo;
import com.example.Hospital.Service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Med")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;
    @Autowired
    private MedicationMapper medicationMapper;
    @GetMapping
    public List<MedicatoinDTO> getMedications(){
        return medicationService.getMedications().stream().map(medicationMapper::toDto).collect(Collectors.toList());
    }
    @PostMapping
    public Medication addMedication(@RequestBody Medication m){
        return medicationService.addMedication(m);
    }
    @DeleteMapping("/{medicationId}")
    public void deleteMedication(@PathVariable("medicationId") long medicationId) {
        medicationService.deleteMedicationById(medicationId);
    }
}
