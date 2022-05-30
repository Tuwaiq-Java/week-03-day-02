package com.example.userexersize.service;

import com.example.userexersize.model.User;
import com.example.userexersize.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "user add !";
    }

    public User getUserByID(Integer id) {
       return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserOlder(Integer age) {
        return userRepository.findByAgeAfter(age);
    }

    public Integer countOfUserByRole(String role) {
        return userRepository.getRole(role);
    }

    public String checkUsernamePassword(String username, String password) {
        Optional<User> currentUser = userRepository.findAllByUsernameAndPassword(username,password);
        if (currentUser.isEmpty()){
            return "Username or password is wrong";
        }else {
            return "Username and password is correct";
        }
    }

    public String updateUser(Integer id, User user) {
        User isAdmin = userRepository.findById(id).get();
        User oldUser = user;
        if (isAdmin == null){
            return "User is not admin";
        }
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setJoiningYear(user.getJoiningYear());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);
        return "User is update";

    }

    public String newPassword(Integer id, String newPassword) {
        User user = userRepository.findById(id).get();
        if (user == null){
            return "user id is wrong";
        }
        user.setPassword(newPassword);
        return "Password updated";
    }

    public String checkUserJoiningYear(Integer id, String joiningYear) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            return "wrong id";
        }
        if (user.get().getJoiningYear().equals(joiningYear)){
            return "true";
        }
        return "false";
    }

    public Optional<User> userJoiningYear(String joiningYear) {
        return userRepository.findByJoiningYearAfter(joiningYear);
    }

    public Object userJoiningYearAndAge(String joiningYear, Integer age) {
        return userRepository.findAllByJoiningYearAndAge(joiningYear,age);
    }
}
