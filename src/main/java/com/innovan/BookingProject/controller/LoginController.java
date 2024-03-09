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

    @GetMapping("/get")
    public List<UserLogin> getAllDetails() {
        return loginService.getAllDetails();
    }

    @GetMapping("/")
    public String test() {
        return "fhj";
    }

    @PostMapping("/signup")
    public String add(@RequestBody UserLogin userLogin) {
        return loginService.add(userLogin);
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

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable String id) {

        return loginService.deleteById(id);
    }


    @PutMapping("/put/{id}")
    public UserLogin updateEntityById(@PathVariable String id, @RequestBody UserLogin updatedEntity) {
        Optional<UserLogin> result = loginService.updateEntityById(id, updatedEntity);
        return result.orElse(null);


    }
}
