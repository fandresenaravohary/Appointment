package com.appointment_management.Repository.Client;

import com.appointment_management.model.Client;

import java.util.List;

public interface ClientDAO {
    void insert(Client client);
    List<Client> findAll();
    List<Client> findId(int id);

    void update (Client client);
    void delete(int id);
}
