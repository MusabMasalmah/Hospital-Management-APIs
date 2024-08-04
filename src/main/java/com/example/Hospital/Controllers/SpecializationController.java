package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.SpecializationDTO;
import com.example.Hospital.Mappers.SpecializationMapper;
import com.example.Hospital.Models.Specialization;
import com.example.Hospital.Service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Spec")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private SpecializationMapper specializationMapper;

    @GetMapping
    public List<SpecializationDTO> getSpecializations(){
        return specializationService.getSpecializations().stream().map(specializationMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public Specialization addSpecializations(@RequestBody Specialization s){
        return specializationService.addSpecializations(s);
    }

    @DeleteMapping("/{specializationId}")
    public void deleteSpecialization(@PathVariable("specializationId") long specializationId) {
        specializationService.deleteSpecializationById(specializationId);
    }


}
