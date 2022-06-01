package com.example.usersmanagement.service;

import com.example.usersmanagement.model.User;
import com.example.usersmanagement.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    public void addUser(User user) {
        userRepo.save(user);
    }
    public User getUserId(Integer userid) {
        return userRepo.findAllById(userid);
    }
    public User getUserEmail(String email) {
        return userRepo.findAllByEmail(email);
    }
    public List<User> getUserOlder(Integer age) {
        return userRepo.findByAgeGreaterThan(age);
    }
    public List<User> getRole(String role) {
        return userRepo.countAllByRole(role);
    }

    public List<User> check(String username, String password) {
        return userRepo.check(username,password);
    }

    public void updateUser(Integer userid, User user) {
        if(userRepo.findAllByRole(user.getRole()).equals("user")){
            User oldUser=userRepo.findById(userid).get();
            oldUser.setId(user.getId());
            oldUser.setPassword(user.getPassword());
            oldUser.setUsername(user.getUsername());
            oldUser.setAge(user.getAge());
            oldUser.setEmail(user.getEmail());
            oldUser.setJoiningYear(user.getJoiningYear());
            userRepo.save(oldUser);
        }
    }

    public void updatePassword(Integer userid, User user) {
        User oldPassword = userRepo.findById(userid).get();
        oldPassword.setPassword(user.getPassword());
    }

    public List<User> joiningYearUserId(Integer userid, String year) {
        return userRepo.findAllByIdAndJoiningYearEquals(userid, year);
    }

    public List<User> joiningYear(String year) {
        return userRepo.findAllByJoiningYearOrJoiningYearAfter(year);
    }

    public List<User> ageAndJoining(Integer age, String year) {
        return userRepo.findAllByAgeEqualsAndJoiningYearEqualsAndJoiningYearIsAfter(age,year);
    }
}
