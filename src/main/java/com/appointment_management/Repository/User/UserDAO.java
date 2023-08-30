package com.appointment_management.Repository.User;

import com.appointment_management.model.User;

import java.util.List;

public interface UserDAO {
    void insert(User u);
    List<User> findAll();
    List<User> findId(int id);

    void update(User u);

    void delete(int id);
}
