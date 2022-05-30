package com.example.usermanagement.repository;

import com.example.usermanagement.models.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MyUsers, Integer> {

    List<MyUsers> findAllByAgeGreaterThan(Integer age);
    Integer countAllByRole(String role);

    MyUsers findByUsername(String username);
    List findAllByJoinYearGreaterThanEqual(String year);
    List findAllByJoinYearLessThanEqual(String year);
}
