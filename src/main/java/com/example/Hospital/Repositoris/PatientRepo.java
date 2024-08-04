package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Patient;
import com.example.Hospital.Models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.name = :name")
    Optional<Patient> findByName(@Param("name") String name);

    @Query("DELETE FROM Patient p WHERE p.name = :name")
    void deleteByName(@Param("name") String name);
}
