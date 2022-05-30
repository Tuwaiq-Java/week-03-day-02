package com.demo.Ex2w3.Repository;

import com.demo.Ex2w3.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer> {

    //ArrayList<Student> findAllByMajor(String major);
    Student findByName(String name);
    List<Student> findAllByAgeGreaterThanEqual(Integer age);
    @Query("SELECT s FROM Student s WHERE s.major=?1 and s.age=?2")
    Student lookForStudent(String major,Integer age);


    //@Query("SELECT s.name s.major where Student.age=?1" + "and Student .major=?2")
    //List<Student> getStudentByAgeAndMajor123(Integer age, String major);


}
