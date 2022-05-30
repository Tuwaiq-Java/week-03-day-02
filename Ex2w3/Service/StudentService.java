package com.demo.Ex2w3.Service;

import com.demo.Ex2w3.Model.Student;
import com.demo.Ex2w3.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentByAge(Integer age) {
        return studentRepository.findAllByAgeGreaterThanEqual(age);
    }

    public Student getStudentByAgeAndMajor(Integer age, String major) {
        return studentRepository.lookForStudent(major,age);
    }
}
