package com.example.Hospital.Service;

import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Repositoris.DoctorRepo;
import com.example.Hospital.Repositoris.SpecializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private DoctorPageService doctorPageService;


    public List<Doctor> getDoctors(){
        return doctorRepo.findAll();
    }

    public Page<Doctor> getDoctorsByPage(Pageable pageable) {
        return doctorPageService.findAll(pageable);
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
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        // Update the doctor's details
        doctor.setName(updatedDoctor.getName());

        // Check if specialization ID is provided and valid
        if (updatedDoctor.getSpecialization() != null && updatedDoctor.getSpecialization().getId() > 0) {
            // Fetch the specialization entity using its ID
            Specialization specialization = specializationRepo.findById(updatedDoctor.getSpecialization().getId())
                    .orElseThrow(() -> new RuntimeException("Specialization not found with id: " + updatedDoctor.getSpecialization().getId()));

            // Set the fetched specialization to the doctor
            doctor.setSpecialization(specialization);
        } else {
            // Handle cases where specializationID is not provided or invalid
            doctor.setSpecialization(null);
        }

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






