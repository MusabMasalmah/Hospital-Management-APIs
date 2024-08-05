package com.example.Hospital.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor() {}

    public Doctor(String name, Specialization specialization, List<Patient> patients) {
        this.name = name;
        this.specialization = specialization;
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
