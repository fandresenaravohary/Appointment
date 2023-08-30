package com.appointment_management.controller;

import com.appointment_management.model.Appointment;
import com.appointment_management.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAdmins(){
        return appointmentService.findAllAppointments();
    }

    @GetMapping("/appointment/{id}")
    public List<Appointment> getById(@PathVariable int id){
        return appointmentService.findById(id);
    }

    @PostMapping("/appointment")
    public Appointment insertAppointment(@RequestBody Appointment toInsert){
        return appointmentService.insert(toInsert);
    }

    @PutMapping("/appointment/{id}")
    public Appointment updateUser(@PathVariable int id, @RequestBody Appointment toUpdate){
        return appointmentService.update(toUpdate);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.delete(id);
    }
}
