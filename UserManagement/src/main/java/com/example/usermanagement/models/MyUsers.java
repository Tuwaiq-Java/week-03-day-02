package com.example.usermanagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "users")
public class MyUsers {
    @Id
    private Integer id;
    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull @Column(nullable = false)
    private String password;
    @Email @Column(unique = true, nullable = false)
    private String email;
    @NotNull @Pattern(regexp = "(?i)(Admin|user)")
    private String role;
    @NotEmpty
    private String joinYear;
    @NotNull @Min(18)
    private Integer age;



}
