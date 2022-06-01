package com.example.week3day2.Service;

import com.example.week3day2.Model.User;
import com.example.week3day2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUser(Integer id){
        return userRepository.findById(id).get();
    }
    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
    public List<User> getUsersByAgeGreaterThan(Integer age){
        return userRepository.getUsersByAgeIsGreaterThan(age);
    }
    public Integer getUsersNumByRole(String role){

        return userRepository.countUsersByRole(role);
    }
    public Boolean checkLogin(String username,String password){

        return userRepository.existsUserByUsernameAndPassword(username,password);
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public Boolean updateUser(Integer id,User new_user){
        Boolean isUserAdmin=userRepository.existsUserByIdAndRole(id,"Admin");
        if(!isUserAdmin){
           return false;
        }
        User old_user=userRepository.findById(id).get();
        old_user.setAge(new_user.getAge());
        old_user.setEmail(new_user.getEmail());
        old_user.setUsername(new_user.getUsername());
        old_user.setPassword(new_user.getPassword());
        old_user.setJoiningYear(new_user.getJoiningYear());
        userRepository.save(new_user);
        return true;
    }
    public void updatePassword(String newPassword,Integer id){
        User old_user=userRepository.findById(id).get();
        old_user.setPassword(newPassword);
        userRepository.save(old_user);
    }
    public Boolean hasJoinedIn(LocalDate joiningYear,Integer id){
        Boolean hasJoined =userRepository.existsUserByIdAndJoiningYear(id,joiningYear);
        return hasJoined;
    }
    public List<User> getUsersByJoiningYear(LocalDate joiningYear){
        return userRepository.getUsersByJoiningYearIsGreaterThanEqual(joiningYear);
    }
    public List<User> getUsersByAgeandJoiningYear(Integer age,LocalDate joiningYear){
    return userRepository.getUsersByJoiningYearIsGreaterThanEqualAndAgeEquals(joiningYear,age);
    }
}
