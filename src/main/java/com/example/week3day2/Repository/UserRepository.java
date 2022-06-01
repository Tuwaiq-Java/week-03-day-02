package com.example.week3day2.Repository;

import com.example.week3day2.Model.User;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
        User getUserByEmail(String email);
        List<User> getUsersByAgeIsGreaterThan(Integer age);
        Integer countUsersByRole(String role);
        Boolean existsUserByUsernameAndPassword(String username,String password);
        Boolean existsUserByIdAndRole(Integer id,String role);
        Boolean existsUserByIdAndJoiningYear(Integer id, LocalDate joiningYear);
        Boolean getUserByIdAndJoiningYearEquals(Integer id, LocalDate joiningYear);
        List<User> getUsersByJoiningYearIsGreaterThanEqual(LocalDate joiningYear);

        List<User> getUsersByJoiningYearIsGreaterThanEqualAndAgeEquals(LocalDate joiningYear,Integer age);

       }
