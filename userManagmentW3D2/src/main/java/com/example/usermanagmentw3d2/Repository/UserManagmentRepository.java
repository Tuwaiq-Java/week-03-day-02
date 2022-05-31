package com.example.usermanagmentw3d2.Repository;


import com.example.usermanagmentw3d2.model.UserManagment;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserManagmentRepository extends JpaRepository<UserManagment,Integer> {

List<UserManagment> findAllById(Integer id);
UserManagment findByEmail(String email);
@Query("SELECT u FROM UserManagment u where u.age=?1")
UserManagment findByAge(String age);

    @Query("select u from UserManagment u group by u.role having ?1")//**

UserManagment findByRoleCount(String role);

@Query("select u from UserManagment  u where u.password=?1")
    UserManagment findByPassword(String password);


    @Query("select u from UserManagment  u where u.username=?1")
    UserManagment findByUsername(String username);
//
//    @Modifying
//    @Query("update UserManagment u set u")
    UserManagment findUserManagment(UserManagment userManagment);







}
