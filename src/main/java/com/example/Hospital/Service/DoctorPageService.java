package com.example.Hospital.Service;

import com.example.Hospital.Models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DoctorPageService extends PagingAndSortingRepository<Doctor, Long> {
    Page<Doctor> findAll(Pageable pageable);
}
