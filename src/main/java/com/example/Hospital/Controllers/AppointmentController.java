package com.example.Hospital.Controllers;

import com.example.Hospital.DTOs.AppointmentDTO;
import com.example.Hospital.Mappers.AppointmentMapper;
import com.example.Hospital.Models.Appointment;
import com.example.Hospital.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Appointment")
@Validated // Enables validation on method parameters
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * Retrieves a list of all appointments.
     * @return A list of AppointmentDTOs.
     */
    @GetMapping
    public List<AppointmentDTO> getAppointments() {
        List<Appointment> appointments = appointmentService.getAppointments();

        return appointments.stream()
                .map(appointmentMapper::toDto)
                .collect(Collectors.toList());
    }


    /**
     * Schedules a new appointment.
     * @param patientId The ID of the patient.
     * @param doctorId The ID of the doctor.
     * @param date The date and time of the appointment.
     * @param reason The reason for the appointment.
     * @return A boolean indicating if the appointment was successfully scheduled.
     */
    @PostMapping("/schedule")
    public boolean scheduleAppointment(
            @RequestParam long patientId,
            @RequestParam long doctorId,
            @RequestParam String date,
            @RequestParam String reason) {
        // Schedules an appointment using the provided details and returns the result
        return appointmentService.scheduleAppointment(patientId, doctorId, date, reason);
    }

    /**
     * Updates an existing appointment.
     * @param appointmentId The ID of the appointment to update.
     * @param patientId The ID of the patient.
     * @param doctorId The ID of the doctor.
     * @param date The new date and time of the appointment.
     * @param reason The new reason for the appointment.
     * @return A boolean indicating if the appointment was successfully updated.
     */
    @PutMapping("/{appointmentId}")
    public boolean updateAppointment(
            @PathVariable("appointmentId") long appointmentId,
            @RequestParam long patientId,
            @RequestParam long doctorId,
            @RequestParam String date,
            @RequestParam String reason) {
        // Updates an appointment with the given ID using the provided details and returns the result
        return appointmentService.updateAppointment(appointmentId, patientId, doctorId, date, reason);
    }

    @DeleteMapping("/{appointmentId}")
    public void deleteAppointment(@PathVariable("appointmentId") long appointmentId) {
        // Deletes the doctor using the service
        appointmentService.deleteAppointmentById(appointmentId);
    }
}
