package com.innovan.BookingProject.repo;

import com.innovan.BookingProject.entity.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface LoginRepo extends MongoRepository<UserLogin,String> {

}
