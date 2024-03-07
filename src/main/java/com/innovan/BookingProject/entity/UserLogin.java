package com.innovan.BookingProject.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Data
@Document(collection = "LoginDetails")
public class UserLogin {
    @MongoId(FieldType.OBJECT_ID)
    private String Id;
    private String userName;
    private String email;
    private Long phone;
    private String password;


}
