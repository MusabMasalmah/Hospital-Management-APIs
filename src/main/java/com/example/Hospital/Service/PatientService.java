package com.example.Hospital.Service;

import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Repositoris.DoctorRepo;
import com.example.Hospital.Repositoris.MediciationRepo;
import com.example.Hospital.Repositoris.PatientRepo;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private MediciationRepo mediciationRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public List<Patient> getPatients(){
        return patientRepo.findAll();
    }

    public Patient addPatient(Patient p){
        return patientRepo.save(p);
    }

    public boolean assignMedToPatient(long medId, long patId) {
        try {
            Patient patient = patientRepo.findById(patId).orElseThrow(() -> new RuntimeException("Error"));
            Medication medication = mediciationRepo.findById(medId).orElseThrow(() -> new RuntimeException("Error"));

            List<Medication> toUpdate = patient.getMedications();
            toUpdate.add(medication);
            patient.setMedications(toUpdate);

            patientRepo.save(patient);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean assignPatientToDoctor(long patId, long docId) {
        try {
            Patient patient = patientRepo.findById(patId).orElseThrow(() -> new RuntimeException("Error"));
            Doctor doctor = doctorRepo.findById(docId).orElseThrow(() -> new RuntimeException("Error"));

            patient.setDoctor(doctor);

            patientRepo.save(patient);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deletePatientById(long patientId) {
        patientRepo.deleteById(patientId);
    }

    public boolean updatePatient(long id, Patient updatedPatient) {
        // Find the patient by id, or throw an exception if not found
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        // Update the patient's details
        patient.setName(updatedPatient.getName());

        // Save the updated patient and check if it was successful
        Patient savedPatient = patientRepo.save(patient);

        // Return true if the save operation was successful
        return savedPatient != null;
    }


}
