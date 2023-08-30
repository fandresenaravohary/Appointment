package com.appointment_management.service;

import com.appointment_management.Repository.Client.ClientDAO;
import com.appointment_management.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    public ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client insert(Client toInsert){
        try {
            this.clientDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public List<Client> findAllClients(){
        try {
            return clientDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> findById(int id){
        try{
            return clientDAO.findId(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Client update(Client toUpdate){
        try{
            this.clientDAO.update(toUpdate);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return toUpdate;
    }

    public void delete(int toDelete){
        try {
            this.clientDAO.delete(toDelete);
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
