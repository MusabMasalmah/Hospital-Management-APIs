package com.example.Hospital.Service;

import com.example.Hospital.Models.Medication;
import com.example.Hospital.Repositoris.MediciationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MediciationRepo mediciationRepo;

    public List<Medication> getMedications(){
        return mediciationRepo.findAll();
    }

    public Medication addMedication(Medication m){
        return mediciationRepo.save(m);
    }

    public Optional<Medication> findMedicationByName(String name) {
        return mediciationRepo.findByName(name);
    }

    public void deleteMedicationByName(String name) {
        mediciationRepo.deleteByName(name);
    }
    public void deleteMedicationById(long medicationId) {
        mediciationRepo.deleteById(medicationId);
    }
    public Medication updateMedication(long id, Medication updatedMedication) {
        Optional<Medication> existingMedicationOpt = mediciationRepo.findById(id);
        if (existingMedicationOpt.isPresent()) {
            Medication existingMedication = existingMedicationOpt.get();
            existingMedication.setName(updatedMedication.getName());

            return mediciationRepo.save(existingMedication);
        } else {
            throw new RuntimeException("Medication not found with id: " + id);
        }
    }
}
