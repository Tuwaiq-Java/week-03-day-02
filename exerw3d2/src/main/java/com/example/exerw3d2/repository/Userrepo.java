package com.example.exerw3d2.repository;

import com.example.exerw3d2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Userrepo extends JpaRepository<Users, Integer> {


    @Query ("select u FROM Users u where u.id=?1 and u.joiningYear=?2")
    Users checkyear(Integer id,String joiningyear);

    @Query("select u from Users u where u.joiningYear=?1")
    List<Users> getalluserinyear (String joiningyear);

    @Query("select u from Users u where u.age=?1 and u.joiningYear=?2")
    List<Users> getageyear (Integer age,String jo );



Users findByEmailEquals(String email);
List<Users>findByAgeGreaterThan(Integer age);
Users findAllByUsernameEqualsAndPasswordEquals(String username,String password);
Integer countByRole(String role);
Users findAllById(Integer id);

//Users findByUsername(String name);
//Users searchAllByUsernameAndPassword(String username,String password);
//Users findUsersByUsernameEqualsAndPasswordEquals(String username,String password);
}
