package com.example.exercise10.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @NotNull(message = "Id is required")
    private Integer id;

    @NotEmpty(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Role is required")
    @Pattern(regexp = ("Admin|User"))
    private String role;

    @NotNull(message = "Joining year is required")
    private Integer joiningYear;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be more than 0")
    private Integer age;


}
