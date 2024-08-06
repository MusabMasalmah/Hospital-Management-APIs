package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecializationRepo extends JpaRepository<Specialization, Long>, PagingAndSortingRepository<Specialization, Long> {
    @Query("SELECT s FROM Specialization s WHERE s.name = :name")
    Optional<Specialization> findByName(@Param("name") String name);

    @Query("DELETE FROM Specialization s WHERE s.name = :name")
    void deleteByName(@Param("name") String name);
}
