package com.example.usersmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @NotEmpty(message = "your name is required")
    private String username;

    @NotEmpty(message = "your password is required")
    private String password;

    @Email(message = "your email must be valid")
    @NotEmpty(message = "your email is required")
    private String email;

    @NotEmpty(message = "your name is required")
    private String role;

    @NotNull(message = "Your joiningYear required")
    @Positive(message = "Your joiningYear must be a number")
    private Integer joiningYear;

    @NotNull(message = "Your age required")
    @Positive(message = "Your age must be a number")
    private Integer age;
}
