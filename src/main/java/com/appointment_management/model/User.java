package com.appointment_management.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;
}
