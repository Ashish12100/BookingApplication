package com.innovan.BookingProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "LoginDetails")
public class UserLogin {
    @MongoId(FieldType.OBJECT_ID)
    private String Id;
    private String username;
    private String email;
    private Long phone;
    private String password;


}
