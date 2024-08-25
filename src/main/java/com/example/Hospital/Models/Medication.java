package com.example.Hospital.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medications")
public class Medication {
    @Id
    @SequenceGenerator(
            name = "medication_sequence",
            sequenceName = "medication_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medication_sequence"
    )
    private long id;
    private String name;
    @ManyToMany(mappedBy = "medications")
    private List<Patient> patients;


    public Medication() {}

    public Medication(long id, String name, List<Patient> patients) {
        this.id = id;
        this.name = name;
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Medicatoin{" +
                "name='" + name + '\'' +
                ", availableMedications=" +
                '}';
    }
}
