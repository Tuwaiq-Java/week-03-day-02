package com.example.dataday2users.services;

import com.example.dataday2users.model.MyUsers;
import com.example.dataday2users.repo.MyUsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyUsersService {
    private final MyUsersRepo myUsersRepo;

    public List<MyUsers> getUsers(){
        return myUsersRepo.findAll();
    }

    public void addUsers(MyUsers myUsers){
        myUsersRepo.save(myUsers);
    }

    public MyUsers getUserById(Integer userid){
       return myUsersRepo.findAllById(userid);
    }

    public MyUsers getUserByEmail(String email){
        return myUsersRepo.findAllByEmail(email);
    }

    public List<MyUsers> getUserByOlderAge(Integer age){
        return myUsersRepo.findByAgeGreaterThan(age);
    }

    public List<MyUsers> countAllByRole(String role){
        return myUsersRepo.countAllByRole(role);
    }

    public List<MyUsers> isFind(String username,String password){
        return myUsersRepo.isFind(username, password);
    }

    public void updateAdmin(Integer userid, MyUsers myUsers){
        if(myUsersRepo.findAllByRole(myUsers.getRole()).equals("admin")){
            MyUsers oldUser=myUsersRepo.findById(userid).get();
            oldUser.setId(myUsers.getId());
            oldUser.setPassword(myUsers.getPassword());
            oldUser.setUsername(myUsers.getUsername());
            oldUser.setAge(myUsers.getAge());
            oldUser.setEmail(myUsers.getEmail());
            oldUser.setJoiningYear(myUsers.getJoiningYear());
            myUsersRepo.save(oldUser);
        }
    }

    public void updatePass(Integer userid,MyUsers myUsers){
            MyUsers oldPass = myUsersRepo.findById(userid).get();
            oldPass.setPassword(myUsers.getPassword());
        }
//        public Integer joining(String joining,Integer userid){
//        if(myUsersRepo.findAllById(userid).equals(userid)){
//
//        }
  //  findAllByIdAndJoiningYearEquals
//        }

    public List<MyUsers> joiningYear(String year){
        return myUsersRepo.findAllByJoiningYearOrJoiningYearAfter(year);
    }

    public List<MyUsers> ageAndJoining(Integer age,String joiningyear){
        return myUsersRepo.findAllByAgeEqualsAndJoiningYearEqualsAndJoiningYearIsAfter(age,joiningyear);
    }

    public List<MyUsers> findByIdAndJoiningYearEquals(Integer userid, String year){

        return myUsersRepo.findAllByIdAndJoiningYearEquals(userid, year);
    }
}

