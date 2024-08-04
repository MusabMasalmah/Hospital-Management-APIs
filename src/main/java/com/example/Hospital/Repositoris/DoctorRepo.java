package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Models.Specialization;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.name = :name")
    Optional<Doctor> findDoctorByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Doctor d SET d.name = :name WHERE d.id = :id")
    void updateDoctorName(@Param("id") Long id, @Param("name") String name);

}
