package com.example.users.Reposetry;

import com.example.users.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
    Users findUsersById(String id);
    Users findUsersByEmail(String email);
    Optional<Users> findAllByAgeGreaterThan(Integer age);
    Integer countAllByRole(String role);
    Boolean findUsersByUsernameAndPassword(String username, String password);
    Optional<Users> findAllByJoiningYearAfter(Integer joiningYear );
    Optional<Users> findAllByAgeGreaterThanAndJoiningYearInAndAgeBefore(Integer age,Integer joiningYear );





}
