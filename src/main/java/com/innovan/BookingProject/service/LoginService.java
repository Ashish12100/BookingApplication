package com.innovan.BookingProject.service;

import com.innovan.BookingProject.entity.UserLogin;
import com.innovan.BookingProject.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    public String add (UserLogin userLogin) {

        if (loginRepo.existsByEmail(userLogin.getEmail())) {
            return "Email already exists. Please choose another email.";
        }

        loginRepo.save(userLogin);

        return "Data added to the database successfully";
    }

    public Optional<UserLogin> findByUsernameAndPassword(String username, String password) {
        return loginRepo.findByUsernameAndPassword(username, password);
    }


}
