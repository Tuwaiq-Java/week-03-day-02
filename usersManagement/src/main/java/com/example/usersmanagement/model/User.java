package com.example.usersmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.sql.Date;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity
public class User {
    @Id
    private String ID;
    @NotEmpty(message = "username is required")
    private String username;
    @NotEmpty(message = "password is required")
    private String password;
    @NotEmpty(message = "email is required")
    @Email(message = "email must be valid")
    private String email;
    @NotEmpty(message = "role is required")
    @Pattern(regexp = "(admin|user)", message = "must be (admin|user)")
    private String role;
    private Date joiningYear;
    @NotNull(message = "age is required")
    @Min(value = 15, message = "minimum is 15")
    private Integer age;
}
