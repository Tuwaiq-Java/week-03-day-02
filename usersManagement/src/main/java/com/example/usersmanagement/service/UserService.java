package com.example.usersmanagement.service;

import com.example.usersmanagement.model.User;
import com.example.usersmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserWithID(String id) {
        return userRepository.findById(id).get();
    }

    public User getUserWithEmail(String email) {
        return userRepository.findUserByEmailEquals(email);
    }

    public List<User> getUserOlderThan(Integer age) {
        return userRepository.findUsersByAgeGreaterThanEqual(age);
    }

    public Integer getTotalCountOfRole(String role) {
        return userRepository.countAllByRoleEquals(role);
    }

    public Integer checkLogin(String username, String password) {
        User user =userRepository.findUserByUsernameEqualsAndPasswordEquals(username,password);
        if (user != null)
            return 1;
        return 0;
    }

    public Integer updateWithAdmin(String userid, User user) {
        Optional<User> oldUser = userRepository.findById(userid);
        if(oldUser.isEmpty()){
            return -1;
        }
        if (oldUser.get().getRole().equals("admin")) {
            if (user.getAge() != null) oldUser.get().setAge(user.getAge());
            if (user.getEmail() != null) oldUser.get().setEmail(user.getEmail());
            if (user.getPassword() != null) oldUser.get().setPassword(user.getPassword());
            if (user.getJoiningYear() != null) oldUser.get().setJoiningYear(user.getJoiningYear());
            userRepository.save(oldUser.get());
            return 1;
        }
        return -1;
    }

    public Integer changePassword(String userid, String password) {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            user.get().setPassword(password);
            userRepository.save(user.get());
            return 1;
        }
            return -1;

    }

    public Integer checkJoiningYear(String userid, String joiningYear) {
        Optional<User> user = userRepository.findById(userid);
        if (user.isPresent()) {
            Date date = Date.valueOf(joiningYear);
            if (user.get().getJoiningYear().equals(date)) {
                return 1;
            }
        }
        return -1;
    }

    public List<User> getUsersByJoiningDate(Date date) {
        System.out.println(date);
        return userRepository.findUsersByJoiningYear33(date);
    }

    public List<User> getUsersByAgeEqualsAndJoiningDateAfter(Date date, Integer age) {
        return userRepository.findUserByJoiningYearEqualsAndJoiningYearBeforeAndAgeEquals22(date, age);
    }
}
