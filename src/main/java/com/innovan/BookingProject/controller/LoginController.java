package com.innovan.BookingProject.controller;

import com.innovan.BookingProject.entity.UserLogin;
import com.innovan.BookingProject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class LoginController {

    @Autowired
    LoginService loginService;

    //TO GET ALL DETAILS
    @GetMapping("/get")
    public List<UserLogin> getAllDetails() {
        return loginService.getAllDetails();
    }


    //TO ADD DETAILS OF THE USER
    @PostMapping("/signup")
    public String add(@RequestBody UserLogin userLogin) {
        return loginService.add(userLogin);
    }

    //TO LOGIN USING USERNAME AND PASSWORD
    @PostMapping("/login")
    public String loginUser(@RequestBody UserLogin userLogin) {

        Optional<UserLogin> login = loginService.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword());

        if (login.isPresent()) {
           // System.out.println("Login successful");
            return "Login successful";
        } else {
        //    System.out.println("Login failed");
            return "Login failed";
        }
    }

    //TO DELETE  DETAILS BY ID.
    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable String id) {

        return loginService.deleteById(id);
    }

    //TO UPDATE DETAILS BY ID.
    @PutMapping("/put/{id}")
    public UserLogin updateById(@PathVariable String id, @RequestBody UserLogin updatedEntity) {
        Optional<UserLogin> result = loginService.updateById(id, updatedEntity);
        return result.orElse(null);


    }
}
