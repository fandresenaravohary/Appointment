package com.appointment_management.service;

import com.appointment_management.Repository.User.UserDAO;
import com.appointment_management.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAllUsers(){
        try {
            return userDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findById(int id){
        try{
            return userDAO.findId(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public User insert(User toInsert){
        try {
            this.userDAO.insert(toInsert);
            return toInsert;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public User update(User toUpdate){
        try {
            this.userDAO.update(toUpdate);
            return toUpdate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int toDelete){
        try {
            this.userDAO.delete(toDelete);
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
