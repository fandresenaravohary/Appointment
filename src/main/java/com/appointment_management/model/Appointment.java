package com.appointment_management.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Appointment {
    private int id;
    private LocalDate appointmentDate;
    private String location;
    private String description;
    private String appointmentType;
}
