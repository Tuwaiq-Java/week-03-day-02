package com.example.usersmanagement.repository;

import com.example.usersmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    // endpoint that takes email and return the user with this email
    @Query("select u from  Users u where u.email=?1")
    Users findByEmail(String email);
    // endpoint that takes age and return the user with older than this age
    List<Users> findAllByAgeGreaterThanEqual(Integer age);
    // endpoint that takes role and return the total count having this role
    @Query("select count(u.role) from Users  u where u.role=?1")
    Long findAllByRole(String role);
    // endpoint that takes username and password and check if it's correct or not
    Users findByUsernameAndPasswordEquals(String username,String password);
    // ~ endpoint that takes userid and user object , update the olduser object with the new object after verifying the userid belong to admin user
    // ~ takes newPassword and userid , update the olduser password with the new Password
    Users findAllByUsernameEquals(Users users);
    //takes joiningYear and userid , and return if this user joined with the date that being sent or not
    @Query("select u from Users  u where u.joiningYear in(:joiningYear)")
    Long findByJoiningYearEquals(Integer joiningYear);
    //endoiunt that takes joiningYear and return all the users who joined in this date or after
    List<Users> findByJoiningYearBeforeAndJoiningYearAfter(Integer joiningYear);
    // endoiunt that takes age and joiningYear and return all the users who joined in this date or before and all have the same age
    List<Users> findAllByAgeAndJoiningYearBefore(Integer age, Integer joiningYear);
}
