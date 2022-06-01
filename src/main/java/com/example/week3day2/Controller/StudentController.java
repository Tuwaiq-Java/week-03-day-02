package com.example.week3day2.Controller;

import com.example.week3day2.Model.Student;
import com.example.week3day2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
  public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }
    @GetMapping("{id}")
    public ResponseEntity getStudent(@PathVariable Integer id){
        return ResponseEntity.status(200).body(studentService.getStudent(id));
    }
    @GetMapping("s/{major}")
    public ResponseEntity getStudentsByName(@PathVariable String major){

        return ResponseEntity.status(200).body(studentService.getStudentsByMajor(major));
    }
    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors error){
        if(error.hasErrors()){
            String err=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(err);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(201).body("Student added");
    }

}
