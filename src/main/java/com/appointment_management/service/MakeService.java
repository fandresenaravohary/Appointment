package com.appointment_management.service;

import com.appointment_management.Repository.Make.MakeDAO;
import com.appointment_management.model.Make;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeService {
    private MakeDAO makeDAO;

    public MakeService(MakeDAO makeDAO) {
        this.makeDAO = makeDAO;
    }

    public List<Make> findAllMake(){
        try {
            return makeDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Make> findById(int id){
        try{
            return makeDAO.findId(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Make insert(Make toInsert){
        try {
            this.makeDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public Make update(Make toUpdate){
        try {
            this.makeDAO.update(toUpdate);
            return toUpdate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int toDelete){
        try {
            this.makeDAO.delete(toDelete);
            System.out.println("Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
