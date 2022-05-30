package com.example.usersystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User {
    @Id
    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID must be positive")
    private Integer id;
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @NotEmpty(message = "password cannot be null")
    private String password;
    @Email(message = "Email has to be in email format")
    @NotEmpty(message = "Email cannot be null")
    private String email;
    @NotEmpty(message = "Role cannot be null")
    private String role;
    @Pattern(regexp = "(\\d{4})",message = "Year has to be four digits")
    private String  joiningYear;
    @NotNull(message = "age cannot be null")
    @Positive(message = "age must be positive")
    private Integer age;

}
