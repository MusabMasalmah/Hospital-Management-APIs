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

}
