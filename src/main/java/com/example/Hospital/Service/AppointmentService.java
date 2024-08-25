package com.example.Hospital.Service;

import com.example.Hospital.Models.Appointment;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Patient;
import com.example.Hospital.Repositoris.AppointmentRepo;
import com.example.Hospital.Repositoris.DoctorRepo;
import com.example.Hospital.Repositoris.PatientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }


    public boolean scheduleAppointment(long patientId, long doctorId, String date, String reason) {
        try {
            Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
            Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));

            Appointment appointment = new Appointment();
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setAppointmentDate(date);
            appointment.setReason(reason);

            appointmentRepo.save(appointment);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAppointment(long id, long patientId, long doctorId, String date, String reason) {
        try {
            Appointment appointment = appointmentRepo.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
            Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
            Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setAppointmentDate(date);
            appointment.setReason(reason);

            appointmentRepo.save(appointment);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteAppointmentById(long id) {
        if (appointmentRepo.existsById(id)) {
            appointmentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }
}
