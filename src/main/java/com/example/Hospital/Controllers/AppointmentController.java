package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.AppointmentDTO;
import com.example.Hospital.Mappers.AppointmentMapper;
import com.example.Hospital.Models.Appointment;
import com.example.Hospital.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @GetMapping
    public List<AppointmentDTO> getAppointments() {
        return appointmentService.getAppointments().stream().map(appointmentMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/schedule")
    public boolean scheduleAppointment(@RequestParam long patientId, @RequestParam long doctorId, @RequestParam LocalDateTime date, @RequestParam String reason) {
        return appointmentService.scheduleAppointment(patientId, doctorId, date, reason);
    }

    @PutMapping("/{appointmentId}")
    public boolean updateAppointment(
            @PathVariable("appointmentId") long appointmentId,
            @RequestParam long patientId,
            @RequestParam long doctorId,
            @RequestParam LocalDateTime date,
            @RequestParam String reason) {
        return appointmentService.updateAppointment(appointmentId, patientId, doctorId, date, reason);
    }
}
