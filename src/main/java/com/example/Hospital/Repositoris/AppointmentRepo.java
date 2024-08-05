package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Appointment;
import com.example.Hospital.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {}
