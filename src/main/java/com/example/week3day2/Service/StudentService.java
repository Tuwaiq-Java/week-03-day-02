package com.example.week3day2.Service;

import com.example.week3day2.Model.Student;
import com.example.week3day2.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student getStudent(Integer id){
        return studentRepository.findById(id).get();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentsByName(String name) {
        return studentRepository.getStudentsByName(name);
    }
    public Student getStudentByAgeandMajor(Integer age, String major){
        return studentRepository.getStudentByAgeAndMajor(age,major);
    }
    public Student getStudentsByMajor(String major){
        return studentRepository.getStudentsbyMajor(major);

    }
}
