package com.example.Hospital.Service;

import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Repositoris.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {
    @Autowired
    private SpecializationRepo specializationRepo;

    public List<Specialization> getSpecializations(){
        return specializationRepo.findAll();
    }

    public Specialization addSpecializations(Specialization s){
        return specializationRepo.save(s);
    }

    public Optional<Specialization> findSpecializationByName(String name) {
        return specializationRepo.findByName(name);
    }

    public void deleteSpecializationByName(String name) {
        specializationRepo.deleteByName(name);
    }
    public void deleteSpecializationById(long specializationId) {
        specializationRepo.deleteById(specializationId);
    }

    public boolean updateSpecialization(long specializationId, String name) {
        try {
            Optional<Specialization> optionalSpecialization = specializationRepo.findById(specializationId);
            if (optionalSpecialization.isPresent()) {
                Specialization specialization = optionalSpecialization.get();
                specialization.setName(name);
                specializationRepo.save(specialization);
                return true;
            } else {
                return false; // Specialization not found
            }
        } catch (Exception e) {
            return false; // Handle exception as needed
        }
    }
}
