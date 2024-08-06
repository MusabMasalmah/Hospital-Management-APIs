package com.example.Hospital.Service;

import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Repositoris.DoctorRepo;
import com.example.Hospital.Repositoris.SpecializationRepo;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private SpecializationRepo specializationRepo;


    public List<Doctor> getDoctors(){
        return doctorRepo.findAll();
    }

    public Doctor addDoctor(Doctor d){
        return doctorRepo.save(d);
    }

    public boolean assignSpecToDoctor(long doctorId, long specializationId) {
        try {
            Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
            Specialization specialization = specializationRepo.findById(specializationId).orElseThrow(() -> new RuntimeException("Specialization not found with id: " + specializationId));

            doctor.setSpecialization(specialization);

            doctorRepo.save(doctor);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Doctor findDoctorByName(String name) {
        return doctorRepo.findDoctorByName(name)
                .orElseThrow(() -> new RuntimeException("Doctor not found with name: " + name));
    }

    public boolean updateDoctor(long id, Doctor updatedDoctor) {
        // Find the doctor by id, or throw an exception if not found
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        // Update the doctor's details
        doctor.setName(updatedDoctor.getName());

        // Save the updated doctor and check if it was successful
        Doctor savedDoctor = doctorRepo.save(doctor);

        // Return true if the save operation was successful
        return savedDoctor != null;
    }


    public void deleteDoctorById(long id) {
        if (doctorRepo.existsById(id)) {
            doctorRepo.deleteById(id);
        } else {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
    }
}






