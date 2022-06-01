package com.example.week3day2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @NotNull(message = "id required")
    private Integer id;
    @NotEmpty(message = "name required")
    private String name;
    @NotNull(message = "age required")
    private Integer age;
    @NotEmpty(message = "major required")
    private String major;
}
