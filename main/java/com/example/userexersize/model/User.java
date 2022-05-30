package com.example.userexersize.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User {
    @Id
    @NotNull(message = "id is required")
    private Integer id;
    @NotEmpty(message = "user name is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "email is required")
    @Email
    private String email;
    @NotEmpty(message = "role is required")
    private String role;
    @NotEmpty(message = "joiningYear is required")
    private String joiningYear;
    @NotNull(message = "joiningYear is required")
    @Positive
    private Integer age;

}
