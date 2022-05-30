package com.example.usermanagement1.serivce;

import com.example.usermanagement1.model.User;
import com.example.usermanagement1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findAllById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    public List<User> getUserByAgeOlder(String age) {
        return userRepository.findAllByAgeGreaterThan(age);
    }



    public Integer getTotalRole(String role) {

        return userRepository.countByRole(role);
    }
    public boolean checkUsernameAndPass(String username, String pass) {
        User user=userRepository.findAllByUsernameEqualsAndPasswordEquals(username,pass);
        if( user!=null){
            return true;
        }

        return false;
    }


    public User updateuser(User user, String id) {
        User user1=userRepository.findAllById(id);
        if (user.getRole().equals("Admin")){
            user1.setUsername(user.getUsername());
            user1.setAge(user.getAge());
            user1.setPassword(user.getPassword());
            user1.setEmail(user.getEmail());
            return   userRepository.save(user);

        }
        return null;

    }

    public void updateUserPassword(String id, String newpassword) {
        User user=userRepository.findAllById(id);
        if (user.getId()!=null){

            user.setPassword(newpassword);
            userRepository.save(user);
        }
    }

    public User checkUserYearJoin(String id, String year) {
        return userRepository.checkyear(id,year);

    }

    public List<User> getAllUserYearJoin(String year) {
        return userRepository.getUserJoin(year);
    }

    public List<User> getByageAndYearJoin(String age, String year) {
        return   userRepository.getByageAndYearJoin(age,year);
    }



}
