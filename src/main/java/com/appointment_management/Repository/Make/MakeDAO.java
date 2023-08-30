package com.appointment_management.Repository.Make;

import com.appointment_management.model.Make;

import java.util.List;

public interface MakeDAO {
    void insert(Make E);

    List<Make> findAll();

    List<Make> findId(int id);
    void update (Make E);
    void delete(int id);
}
