package com.appointment_management.service;

import com.appointment_management.Repository.Admin.AdminDAO;
import com.appointment_management.model.Admin;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    public AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin insert(Admin toInsert){
        try {
            this.adminDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public List<Admin> findAllAdmins(){
        try {
            return adminDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Admin> findById(int id){
        try{
            return adminDAO.findId(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Admin update(Admin toUpdate){
        try{
            this.adminDAO.update(toUpdate);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return toUpdate;
    }

    public void delete(int toDelete){
        try {
            this.adminDAO.delete(toDelete);
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
