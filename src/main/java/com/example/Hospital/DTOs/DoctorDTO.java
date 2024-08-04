package com.example.Hospital.DTOs;

import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Specialization;

import java.util.List;

public class DoctorDTO {
    private long id;
    private String name;
    private long specializationID;
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

    public long getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(long specializationID) {
        this.specializationID = specializationID;
    }

    public List<Long> getPatientsIDs() {
        return patientsIDs;
    }

    public void setPatientsIDs(List<Long> patientsIDs) {
        this.patientsIDs = patientsIDs;
    }
}