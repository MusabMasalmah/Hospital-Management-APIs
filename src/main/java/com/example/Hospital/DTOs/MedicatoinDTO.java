package com.example.Hospital.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class MedicatoinDTO {
    private long id;
    @NotBlank(message = "Name cannot be blank")
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

    @Override
    public String toString() {
        return "MedicatoinDTO{" +
                "name='" + name + '\'' +
                ", availableMedications=" +
                '}';
    }
}
