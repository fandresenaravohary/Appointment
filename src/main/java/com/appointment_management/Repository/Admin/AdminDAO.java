package com.appointment_management.Repository.Admin;

import com.appointment_management.model.Admin;

import java.util.List;

public interface AdminDAO {
    void insert(Admin A);

    List<Admin> findAll();

    List<Admin> findId(int id);

    void update (Admin A);
    void delete(int id);
}
