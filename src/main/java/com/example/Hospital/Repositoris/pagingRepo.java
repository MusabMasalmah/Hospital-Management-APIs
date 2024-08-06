package com.example.Hospital.Repositoris;

import com.example.Hospital.Models.Specialization;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface pagingRepo extends PagingAndSortingRepository<Specialization, Long> {
}
