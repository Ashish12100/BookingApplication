package com.innovan.BookingProject.controller;

import com.innovan.BookingProject.entity.UserLogin;
import com.innovan.BookingProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String test(){
        return "fhj";
    }
    @PostMapping("/add")
    public String add(@RequestBody UserLogin userLogin){
        loginService.add(userLogin);
        return "Success";
    }

    @PostMapping("/login")

    public String loginUser(@RequestBody UserLogin userLogin) {

        Optional<UserLogin> login = loginService.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

        if (login.isPresent()) {
            System.out.println("Login successful");
            return "Login successful";
        } else {
            System.out.println("Login failed");
            return "Login failed";
        }
    }
}
