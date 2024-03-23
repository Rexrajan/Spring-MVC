package com.springboot.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SpringBoot.dao.EmployeeRepository;
import com.springboot.SpringBoot.dao.UserRepository;
import com.springboot.SpringBoot.model.Employee;
import com.springboot.SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired private UserRepository userRepo;

    public List<User> getAllUser(){

        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void delete(long id){
        userRepo.deleteById(id);

    }

    public User getById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return user;
    }

}