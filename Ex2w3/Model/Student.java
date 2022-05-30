package com.demo.Ex2w3.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;


@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Student {

    @Id
    private Integer id;
    //@Column(name = "student_name",unique = true,nullable = false)
    @NotEmpty(message = "Name is required !")
    private String name;
    @NotNull(message = "Age is required !")
    @Positive(message = "Age must be more than 0")
    @Range(min = 18,message = "You must be more than 18")
    private Integer age;
    private String major;


}

