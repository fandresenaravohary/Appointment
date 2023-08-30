package com.appointment_management.Repository.Appointment;

import com.appointment_management.model.Appointment;

import java.util.List;

public interface AppointmentDAO {
    void insert(Appointment a);
    List<Appointment> findAll();

    List<Appointment> findId(int id);
    void update (Appointment a);
    void delete(int id);
}
