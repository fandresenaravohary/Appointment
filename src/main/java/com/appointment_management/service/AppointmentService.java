package com.appointment_management.service;

import com.appointment_management.Repository.Appointment.AppointmentDAO;
import com.appointment_management.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public List<Appointment> findAllAppointments(){
        try {
            return appointmentDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Appointment> findById(int id){
        try{
            return appointmentDAO.findId(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Appointment insert(Appointment toInsert){
        try {
            this.appointmentDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public Appointment update(Appointment toUpdate){
        try{
            this.appointmentDAO.update(toUpdate);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return toUpdate;
    }

    public void delete(int toDelete){
        try {
            this.appointmentDAO.delete(toDelete);
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
