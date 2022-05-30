package com.example.dataday2users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class MyUsers {
    @Id
    private Integer id;
    private String username;
    private String password;
    @Email @Column(unique = true)
    private String email;
    @Pattern(regexp = "admin|user")
    private String role;
    private String joiningYear;
    private Integer age;

}
