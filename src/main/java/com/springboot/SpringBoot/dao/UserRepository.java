package com.springboot.SpringBoot.dao;

import com.springboot.SpringBoot.model.Employee;
import com.springboot.SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
