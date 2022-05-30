package com.example.usersystem.service;

import com.example.usersystem.model.User;
import com.example.usersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public User findUserById(Integer id){
        return userRepository.findUserById(id);
    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public List<User> findUserByAgeGreaterThanEqual(Integer age){
        return userRepository.findUserByAgeGreaterThanEqual(age);
    }
    public  Integer getRoles(String role){
        return userRepository.getRoles(role);
    }
//    public  Boolean checkUsers(String username,String password){
//        return userRepository.checkUsers(username,password);
//    }
    public boolean checkUsers(String username,String password){
        if(userRepository.findUserByUsernameAndPassword(username,password)!= null)
            return true;
        return false;
    }
    public List<User> ageAndJoinintgYear(Integer age,String joiningYear){
        return userRepository.ageAndJoinintgYear(age,joiningYear);
    }
    public boolean updateUser(User user,Integer id){
        User newUser = userRepository.findById(id).get();
        if(newUser != null) {
            if (newUser.getRole().equals("Admin")) {
                newUser.setUsername(user.getUsername());
                newUser.setEmail(user.getEmail());
                newUser.setPassword(user.getPassword());
                newUser.setAge(user.getAge());
                newUser.setJoiningYear(user.getJoiningYear());
                userRepository.save(newUser);
                return true;
            }
        }
        return false;
    }
    public boolean updatePassword(Integer id,String password){
        User newUser = userRepository.findById(id).get();
        if(newUser != null){
            newUser.setPassword(password);
            userRepository.save(newUser);
            return true;
        }
        return false;
    }
    public boolean checkJoinYear(String joiningYear, Integer id)  {
//        User newUser = userRepository.findById(id).orElseThrow(()->new Exception("User not found"));
        User checkUser = userRepository.checkJoinYear(joiningYear,id);
        if(checkUser != null){
            if(checkUser.getJoiningYear().equals(joiningYear))
            return true;
        }

            return false;
    }
    public  List<User> getUsersByJoiningYear(String joiningYear){
        return userRepository.getUsersByJoiningYear(joiningYear);
    }
}
