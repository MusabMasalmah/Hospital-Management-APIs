package com.example.Hospital.Mappers;

import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Models.Specialization;
import org.springframework.stereotype.Component;

@Component
public class SpecializationMapper {
    public SpecializationDTO toDto(Specialization specialization) {
        SpecializationDTO dto = new SpecializationDTO();
        dto.setId(specialization.getId());
        dto.setName(specialization.getName());
        return dto;
    }
}
