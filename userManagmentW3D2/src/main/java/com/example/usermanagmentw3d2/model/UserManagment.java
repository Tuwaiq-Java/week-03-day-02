package com.example.usermanagmentw3d2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor @Data @NoArgsConstructor

public class UserManagment {

    @Id
    @NotNull
    @Positive
    @Column(nullable = false , unique = true)
     private Integer id;

    @NotEmpty
    @Column(nullable = false , unique = true)
     private String username;

    @NotEmpty
    @Column(nullable = false)
    //@Pattern(regexp = "  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$\n")
     private String password;

    @NotEmpty
    @Email
    @Column(nullable = false)
     private String email;
    @NotEmpty
    @Column(nullable = false)
    @Pattern(regexp = "(Admin | SuperUser | User)")
    private String role;

    @NotEmpty
    @Column(nullable = false)
     private String joiningYear;
    @NotEmpty
    @Column(nullable = false)
    @Positive
    @Range(min = 18)
     private String age ;


}
