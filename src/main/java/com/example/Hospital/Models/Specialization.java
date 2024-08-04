package com.example.Hospital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "specializations")
public class Specialization {
    @Id
    @SequenceGenerator(
            name = "specialization_sequence",
            sequenceName = "specialization_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "specialization_sequence"
    )
    private long id;
    private String name;
    @OneToOne(mappedBy = "specialization")
    private Doctor doctor;

    public Specialization() {}

    public Specialization(long id, String name, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
