package com.example.exercise10.repository;

import com.example.exercise10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findByEmail(String email);

    List<User> findAllByAgeGreaterThanEqual(Integer age);

    Integer countAllByRole(String role);

    List<User> findAllByUsernameEqualsAndPasswordEquals(String username, String password);

    @Query(value = "SELECT u FROM User u WHERE u.id=?1 and u.joiningYear=?2")
    User lookForUser(Integer id, Integer joiningYear);

    List<User> findAllByJoiningYearGreaterThanEqual(Integer joiningYear);

    List<User> findAllByAgeAndJoiningYearLessThanEqual(Integer age, Integer joiningYear);


}
