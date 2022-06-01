package com.example.usersmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User {
    @Id
    private Integer id;
    private  String username;
    private  String password;
    @Email
    @Column(unique = true)
    private  String email;
    private  String role;
    private  String joiningYear;
    private  Integer age;


}
