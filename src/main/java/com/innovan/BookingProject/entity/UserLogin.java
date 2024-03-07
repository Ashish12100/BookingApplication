package com.innovan.BookingProject.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "LoginDetails")
public class UserLogin {
    @MongoId(FieldType.OBJECT_ID)
    private String Id;
    private String username;
    private String email;
    private Long phone;
    private String password;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLogin(String id, String username, String email, Long phone, String password) {
        Id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public UserLogin() {
    }
}
