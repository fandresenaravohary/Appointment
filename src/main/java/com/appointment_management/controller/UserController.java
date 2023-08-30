package com.appointment_management.controller;

import com.appointment_management.model.User;
import org.springframework.web.bind.annotation.*;
import com.appointment_management.service.UserService;

import java.util.List;

@RestController
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public List<User> getById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User insertUser(@RequestBody User toInsert){
        return userService.insert(toInsert);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User toUpdate){
        return userService.update(toUpdate);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.delete(id);
    }

}
