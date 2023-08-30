package com.appointment_management.controller;

import com.appointment_management.model.Client;
import com.appointment_management.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    public ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping("/client/{id}")
    public List<Client> getById(@PathVariable int id){
        return clientService.findById(id);
    }

    @PostMapping("/Client")
    public Client insertClient(@RequestBody Client toInsert){
        return clientService.insert(toInsert);
    }

    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client toUpdate){
        return clientService.update(toUpdate);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable int id){
        clientService.delete(id);
    }
}
