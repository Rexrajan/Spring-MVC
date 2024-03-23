package com.springboot.SpringBoot.web;


import com.springboot.SpringBoot.model.Employee;
import com.springboot.SpringBoot.model.User;
import com.springboot.SpringBoot.service.EmployeeService;
import com.springboot.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

   /* @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }*/

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alluserlist", userService.getAllUser());
        return "user_index";
    }

    @GetMapping("/addnewUser")
    public String loadEmployee(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/User/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteForm(@PathVariable(value = "id") long id, Model model){
        userService.delete(id);
        return "redirect:/User/";
    }


    @GetMapping("/UpdateUser/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user_update";
    }
}