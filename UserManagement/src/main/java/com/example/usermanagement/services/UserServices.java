package com.example.usermanagement.services;


import com.example.usermanagement.models.MyUsers;
import com.example.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public List getUsers(){
        return userRepository.findAll();
    }
    public void addUser(MyUsers user){
        userRepository.save(user);
    }

    public MyUsers getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public List<MyUsers> getUserByAge(Integer age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }
    public Integer getUserByRole(String role) {
        return userRepository.countAllByRole(role);
    }

    public Boolean authenticateUser(String username, String password) {
        MyUsers user = userRepository.findByUsername(username);
        if(user != null){
            if (user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Boolean updateUser(MyUsers user, Integer userId) {
        MyUsers usr = userRepository.findById(userId).get();
        if(usr.getRole().equals("Admin")){
            usr.setAge(user.getAge());
            usr.setEmail(user.getEmail());
            usr.setPassword(user.getPassword());
            usr.setJoinYear(user.getJoinYear());
            usr.setRole(user.getRole());
            usr.setUsername(user.getUsername());
            userRepository.save(usr);
            return true;
        }
        return false;


    }

    public boolean updateUserPassword(Integer userId, String password) {
        MyUsers user = userRepository.findById(userId).get();
        if(user != null){
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }
        return false;
    }
    public Integer checkYear(Integer userId, String year) {
        MyUsers user = userRepository.findById(userId).get();
        if(user != null){
            if(user.getJoinYear().equals(year)){
                return 0;//Correct join year
            }
            return 1;//Wrong year
        }
        return -1;//Invalid id
    }

    public List getUsersByYear(String year){
        List<MyUsers> users = userRepository.findAllByJoinYearGreaterThanEqual(year);
        return users;
    }

    public List getUsersByAgeAndYear(String year, Integer age){
       List<MyUsers> users = userRepository.findAllByJoinYearLessThanEqual(year);
       List result = new ArrayList();
       for(MyUsers user: users){
           if(user.getAge() == age){
               result.add(user);
           }
       }
       return result;
    }

}
