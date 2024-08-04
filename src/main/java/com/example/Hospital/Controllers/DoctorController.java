package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.DoctorDTO;
import com.example.Hospital.Mappers.DoctorMapper;
import com.example.Hospital.Models.Doctor;
import com.example.Hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;

    @GetMapping
    public List<DoctorDTO> getDoctors(){
        return doctorService.getDoctors().stream().map(doctorMapper::toDto).collect(Collectors.toList());
    }
    @GetMapping("/byName")
    public DoctorDTO getDoctorByName(@RequestBody String name){
        Doctor doctor = doctorService.findDoctorByName(name);
        return doctorMapper.toDto(doctor);
    }
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor d){
        return doctorService.addDoctor(d);
    }

    @PostMapping("{doctorId}/to/{specId}")
    public boolean assignSpecToDoctor(@PathVariable("doctorId") long doctorId,@PathVariable("specId") long specId) {
        return doctorService.assignSpecToDoctor(doctorId, specId);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(@PathVariable("doctorId") long doctorId) {
        doctorService.deleteDoctorById(doctorId);
    }
}
