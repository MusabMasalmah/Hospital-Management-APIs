package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.PatientDTO;
import com.example.Hospital.Mappers.PatientMapper;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;

    @GetMapping
    public List<PatientDTO> getPatients(){
        return patientService.getPatients().stream().map(patientMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient p){
        return patientService.addPatient(p);
    }

    @PostMapping("/med/{medId}/to/{patId}")
    public boolean assignMedToPatient(@PathVariable("medId") long medId,@PathVariable("patId") long patId) {
        return patientService.assignMedToPatient(medId, patId);
    }

    @PostMapping("/patient/{patId}/to/{docId}")
    public boolean assignPatientToDoctor(@PathVariable("patId") long patId,@PathVariable("docId") long docId) {
        return patientService.assignPatientToDoctor(patId, docId);
    }
    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable("patientId") long patientId) {
        patientService.deletePatientById(patientId);
    }

    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable("patientId") long patientId, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(patientId, updatedPatient);
    }
}
