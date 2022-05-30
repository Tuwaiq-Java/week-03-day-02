package com.example.usersmanagement.repository;

import com.example.usersmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByEmailEquals(String email);
    List<User> findUsersByAgeGreaterThanEqual(Integer age);

    Integer countAllByRoleEquals(String role);

    User findUserByUsernameEqualsAndPasswordEquals(String username, String password);

    @Query("SELECT u from User u where u.joiningYear=?1 or u.joiningYear>?1")
    List<User> findUsersByJoiningYear33(Date joiningDate);

//    @Query("SELECT u from User u where u.joiningYear=?1 or u.joiningYear <?1 and u.age=?2")
    @Query("SELECT u from User u where (u.joiningYear=?1 or u.joiningYear <?1) and u.age=?2")
    List<User> findUserByJoiningYearEqualsAndJoiningYearBeforeAndAgeEquals22(Date joiningDate, Integer age);
}
