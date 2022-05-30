package com.example.userexersize.repository;

import com.example.userexersize.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByAgeAfter(Integer age);

    Optional<User> findAllByUsernameAndPassword(String username, String password);

    Optional<User> findByJoiningYearAfter(String joiningYear);

    User findAllByJoiningYearAndAge(String joiningYear, Integer age);

    @Query("SELECT count (u) from User u where u.role=?1")
    Integer getRole(String role);
}
