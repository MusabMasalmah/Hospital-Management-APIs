package com.example.Hospital.DTOs;

import com.example.Hospital.Models.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class MedicatoinDTO {
    private long id;
    private String name;
    private List<Long> patientsIDs;

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

    public List<Long> getPatientsIDs() {
        return patientsIDs;
    }

    public void setPatientsIDs(List<Long> patientsIDs) {
        this.patientsIDs = patientsIDs;
    }
}
