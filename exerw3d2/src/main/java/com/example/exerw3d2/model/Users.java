package com.example.exerw3d2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Users {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String joiningYear;
    @Column(nullable = false)
    private Integer age;




}
