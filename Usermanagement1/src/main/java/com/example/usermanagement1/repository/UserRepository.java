package com.example.usermanagement1.repository;

import com.example.usermanagement1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findAllById(String id);
    User findAllByEmail(String email);
    List<User> findAllByAgeGreaterThan(String age);
    Integer countByRole(String role);
    User findAllByUsernameEqualsAndPasswordEquals(String username,String password);
    //User findAllByIdEqualsAAndJoiningYearEquals(String id,String oiningYear)
    @Query("SELECT u FROM User u where u.id=?1 and u.joiningYear=?2")
    User checkyear(String id,String  joiningYear);
    //List<User> findAllByJoiningYearEqualsAndJoiningYearAfter(String joiningYear )
    @Query("SELECT u FROM User u where  u.joiningYear>=?1")
    List<User> getUserJoin(String joiningYear);


    // List<User> findAllByAgeEqualsAndJoiningYearBeforeOrJoiningYearEquals(String age,String joiningYear);
    @Query("SELECT u FROM User u where u.age=?1 and u.joiningYear<=?2")
    List<User> getByageAndYearJoin(String age,String joiningYear);






}
