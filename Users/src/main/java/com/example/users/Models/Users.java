package com.example.users.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Users {
  @Id
  @Size(min = 3, message = "Length id must be more than 3")
  private String id;
  @NotEmpty(message = "name Cannot be null")
  @Size(min = 2,message = "Length name more than 2")
  @Column(unique = true)
  private String username;
  @Column(nullable = false)
  @NotEmpty(message = "password Cannot be null")
  private String password ;
  @Email
  @NotEmpty
  @NotEmpty(message = "email Cannot be null")
  private String email ;
  @NotEmpty
  @NotEmpty(message = "role Cannot be null")
  private String role ;
  @NotNull(message = "year Cannot be null")
  private Integer joiningYear ;
  @NotNull (message = "age Cannot be null")
  private Integer age;
}
