package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Medication;
import com.example.Hospital.Models.Specialization;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface MediciationRepo extends JpaRepository<Medication, Long> {
    @Query("SELECT m FROM Medication m WHERE m.name = :name")
    Optional<Medication> findByName(@Param("name") String name);

    @Query("DELETE FROM Medication m WHERE m.name = :name")
    void deleteByName(@Param("name") String name);
}
