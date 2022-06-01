package com.example.usersmanagement.repo;

import com.example.usersmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository <User,Integer> {

    User findAllById(Integer userid);
    List<User> findAllByRole(String role);
    User findAllByEmail (String email);
    List<User>findByAgeGreaterThan(Integer age);
    List<User>countAllByRole(String role);
    ///////////////===============/////////////
    @Query("SELECT up from User up where up.username=?1 and up.password=?2")
    List<User>check(String username,String password);
    List<User> findAllByIdAndJoiningYearEquals(Integer userid,String year);
    List<User> findAllByJoiningYearOrJoiningYearAfter(String year);
    List<User> findAllByAgeEqualsAndJoiningYearEqualsAndJoiningYearIsAfter(Integer age,String joiningyear);
    
}

