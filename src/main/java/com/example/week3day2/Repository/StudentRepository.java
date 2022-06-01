package com.example.week3day2.Repository;

import com.example.week3day2.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student getStudentsByName(String name);
    Student getStudentByAgeAndMajor(Integer age,String major);
    @Query(value = "SELECT s from Student s where s.major=?1")
    Student getStudentsbyMajor(String major);
}
