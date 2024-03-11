package com.innovan.BookingProject.service;

import com.innovan.BookingProject.entity.UserLogin;
import com.innovan.BookingProject.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
            @Autowired
            LoginRepo loginRepo;

            //TO ADD THE DETAILS
            public String add (UserLogin userLogin)
            {
                if (loginRepo.existsByEmail(userLogin.getEmail())) {
                return "Email already exists. Please choose another email.";
                }
                loginRepo.save(userLogin);
                return "Data added to the database successfully";
                }


        //TO FIND DETAILS BY USERNAME AND PASSWORD
        public Optional<UserLogin> findByUsernameAndPassword(String username, String password) {
        return loginRepo.findByUsernameAndPassword(username, password);
        }


        //TO GET ALL DETAILS IN THE DATABASE
        public List<UserLogin> getAllDetails(){
        return loginRepo.findAll();
        }


        //TO DELETE BY ID
        public String deleteById(String id){
        loginRepo.deleteById(id);
        return "Deleted";
         }


        //TO UPDATE DETAILS BY ID
        public Optional<UserLogin> updateById(String id, UserLogin userLogin){
        Optional<UserLogin> existingId = loginRepo.findById(id);
        if (existingId.isPresent()){
            UserLogin userLoginToUpdate = existingId.get();
            userLoginToUpdate.setUsername(userLogin.getUsername());
            userLoginToUpdate.setEmail(userLogin.getEmail());
            userLoginToUpdate.setPhone(userLogin.getPhone());
            userLoginToUpdate.setPassword(userLogin.getPassword());
            return Optional.of(loginRepo.save(userLoginToUpdate));
            }
            return Optional.empty();
            }

            }
