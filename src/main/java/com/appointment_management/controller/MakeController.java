package com.appointment_management.controller;

import com.appointment_management.model.Make;
import com.appointment_management.service.MakeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MakeController {
    public MakeService makeService;
    public MakeController(MakeService makeService) {
        this.makeService = makeService;
    }

    @GetMapping("/Make")
    public List<Make> getAllMake(){
        return makeService.findAllMake();
    }

    @GetMapping("/Make/{id}")
    public List<Make> getById(@PathVariable int id){
        return makeService.findById(id);
    }

    @PostMapping("/Make")
    public Make insertMake(@RequestBody Make toInsert){
        return makeService.insert(toInsert);
    }

    @PutMapping("/Make/{id}")
    public Make updateMake(@PathVariable int id, @RequestBody Make toUpdate){
        return makeService.update(toUpdate);
    }

    @DeleteMapping("/Make/{id}")
    public void deleteMake(@PathVariable int id){
        makeService.delete(id);
    }
}
