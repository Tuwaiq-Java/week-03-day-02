package com.example.dataday2users.repo;

import com.example.dataday2users.model.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyUsersRepo extends JpaRepository<MyUsers,Integer> {

    MyUsers findAllById(Integer userid);

    List<MyUsers> findAllByRole(String role);

    MyUsers findAllByEmail(String email);

    List<MyUsers> findByAgeGreaterThan(Integer age);

    List<MyUsers> countAllByRole(String role);

    @Query("SELECT up from MyUsers up where up.username=?1 and up.password=?2")
    List<MyUsers> isFind(String username,String password);

    List<MyUsers> findAllByIdAndJoiningYearEquals(Integer userid,String year);


    List<MyUsers> findAllByJoiningYearOrJoiningYearAfter(String year);

   List<MyUsers> findAllByAgeEqualsAndJoiningYearEqualsAndJoiningYearIsAfter(Integer age,String joiningyear);

}
