package com.example.exercise10.service;

import com.example.exercise10.model.User;
import com.example.exercise10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUsers(User user) {
        userRepository.save(user);
    }


    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUserByOlderAge(Integer age) {
        return userRepository.findAllByAgeGreaterThanEqual(age);
    }

    public Integer getCountOfRole(String role) {
        return userRepository.countAllByRole(role);
    }

    public List<User> checkUsernameAndPass(String username, String password) {
        return userRepository.findAllByUsernameEqualsAndPasswordEquals(username,password);
    }

    public void updateUser(Integer userId, User user) {
        User currentUser = getUserById(userId);
        if(currentUser.getRole().equals("Admin")) {
            userRepository.save(user);
        }
    }

    public void updatePassword(String password, Integer userId) {
        User oldUser = userRepository.findById(userId).get();
        oldUser.setPassword(password);
        userRepository.save(oldUser);
    }

    public User checkJoiningYear(Integer id, Integer joiningYear) {
           return userRepository.lookForUser(id,joiningYear);
    }

    public List<User> checkJoiningYearUsers(Integer joiningYear) {
        return userRepository.findAllByJoiningYearGreaterThanEqual(joiningYear);
    }

    public List<User> checkJoiningYearAndAge(Integer age, Integer joiningYear) {
        return userRepository.findAllByAgeAndJoiningYearLessThanEqual(age,joiningYear);
    }
}
