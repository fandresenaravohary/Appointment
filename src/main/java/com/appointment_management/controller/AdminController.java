package com.appointment_management.controller;

import com.appointment_management.model.Admin;
import com.appointment_management.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    public AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins(){
        return adminService.findAllAdmins();
    }

    @GetMapping("/admin/{id}")
    public List<Admin> getById(@PathVariable int id){
        return adminService.findById(id);
    }

    @PostMapping("/admin")
    public Admin insertAdmin(@RequestBody Admin toInsert){
        return adminService.insert(toInsert);
    }

    @PutMapping("/admin/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin toUpdate){
        return adminService.update(toUpdate);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteUser(@PathVariable int id){
        adminService.delete(id);
    }


}

