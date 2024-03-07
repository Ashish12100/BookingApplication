package com.innovan.BookingProject.controller;

import com.innovan.BookingProject.entity.UserLogin;
import com.innovan.BookingProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
