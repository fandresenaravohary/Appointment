package com.appointment_management.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Admin {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private char gender;
    private String password;
}
