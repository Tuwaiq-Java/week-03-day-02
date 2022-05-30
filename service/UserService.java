package com.example.usersmanagement.service;

import com.example.usersmanagement.model.Users;
import com.example.usersmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Users> getUsers() {
        return userRepository.findAll();
    }
    public boolean addUsers(Users users) {
         userRepository.save(users);
         return true;
    }
    // endpoint that takes users id and return the user with this id
    public Optional<Users> getUsersbyId(Long id) {
      return userRepository.findById(id);
    }
    // endpoint that takes email and return the user with this email
    public Optional<Users> getUsersbyEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
    // endpoint that takes age and return the user with older than this age
    public List<Users> getUsersbyAge(Integer age) {
        return userRepository.findAllByAgeGreaterThanEqual(age);
    }
    // endpoint that takes role and return the total count having this role
    public Long getUsersbyRole(String role) {
       return userRepository.findAllByRole(role);
    }
    // endpoint that takes username and password and check if it's correct or not
    public boolean getCheck(String username, String password) {
        userRepository.findByUsernameAndPasswordEquals(username,password);
        return true;
    }
    // endpoint that takes userid and user object , update the olduser object with the new object after verifying the userid belong to admin user
    public boolean editUsers(Users users) {
        Users EditUser = userRepository.findAllByUsernameEquals(users);
        EditUser.setUsername(users.getUsername());
        EditUser.setPassword(users.getPassword());
        userRepository.save(users);
        return true;
    }
    //takes newPassword and userid , update the olduser password with the new Password
    public boolean editUsersPwd(Users users) {
        Users EditUser = userRepository.findAllByUsernameEquals(users);
        EditUser.setPassword(users.getPassword());
        userRepository.save(users);
        return true;
    }
    //takes joiningYear and userid , and return if this user joined with the date that being sent or not
    public Long getUsersbyDate(Integer joiningYear) {
       return userRepository.findByJoiningYearEquals(joiningYear);
    }
    //endoiunt that takes joiningYear and return all the users who joined in this date or after
    public List<Users> getUsersbyDateStart(Integer joiningYear) {
        return userRepository.findByJoiningYearBeforeAndJoiningYearAfter(joiningYear);
    }
    // endoiunt that takes age and joiningYear and return all the users who joined in this date or before and all have the same age
    public List<Users> getUsersbyDateAndAge(Integer age,Integer joiningYear) {
        return userRepository.findAllByAgeAndJoiningYearBefore(age,joiningYear);
    }
}
