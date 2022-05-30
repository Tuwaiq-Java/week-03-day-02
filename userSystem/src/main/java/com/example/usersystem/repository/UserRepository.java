package com.example.usersystem.repository;

import com.example.usersystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    List<User> findUserByAgeGreaterThanEqual(Integer age);
    @Query("SELECT COUNT (u) FROM User u where u.role=?1")
    Integer getRoles(String role);
//    @Query("SELECT u FROM  User u where u.username=?1 and u.password =?2")
//    Boolean checkUsers(String username,String password);
    User findUserByUsernameAndPassword(String username,String password);
    @Query("SELECT u FROM User u where u.age=?1 and u.joiningYear<=?2")
    List<User> ageAndJoinintgYear(Integer age,String  joiningYear);
//    @Modifying
//    @Query("UPDATE User u SET u.password =?2 where u.id =?1")
//    void updatePassword(Integer id,String password);
    @Query("SELECT  u from User u where u.joiningYear =?1")
    List<User> getUsersByJoiningYear(String joiningYear);
    @Query("SELECT u from User u where u.joiningYear =?1 and u.id =?2")
    User checkJoinYear(String  joiningYear,Integer id);
}
