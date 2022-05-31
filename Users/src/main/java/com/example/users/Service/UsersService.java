package com.example.users.Service;

import com.example.users.Models.Users;
import com.example.users.Reposetry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
//1
    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    //2
    public void addUser(Users users) {
        userRepository.save(users);
    }


    public Users findUsersById(String id){
        return userRepository.findUsersById(id);
    }
    public Users getUserByEmail(String email){
        return userRepository.findUsersByEmail(email);

    }
    public Boolean updateUserById(Users users, String id) {
        Users users1= userRepository.findById(id).get();
        if (users1==null){
            return false;
        }
        if (users1.getRole().equals("Admin")) {
            users1.setAge(users.getAge());
            users1.setPassword(users.getPassword());
            users1.setRole(users.getRole());
            users1.setUsername(users.getUsername());
            users1.setEmail(users.getEmail());
            users1.setJoiningYear(users.getJoiningYear());
            userRepository.save(users1);
            return true;
        }
        return false;
    }
    public Boolean checkJoiningYear(String id,Integer joiningYear){
        Users users1= userRepository.findById(id).get();
        if (users1==null){
            return false;
        }
        if(users1.getJoiningYear().equals(joiningYear)){
            return true;
        }
        return false;
    }
    public Boolean updateUserByPassword(String id,String password) {
        Users users1= userRepository.findById(id).get();
        if (users1==null){
            return false;
        }
            users1.setPassword(password);
            userRepository.save(users1);
            return true;
    }
    public Optional<Users> findUsersByYear (Integer joiningYear ){
        return userRepository.findAllByJoiningYearAfter(joiningYear);
    }
    public Optional<Users> findUsersByAgeAndYear (Integer age,Integer joiningYear ){
        return userRepository.findAllByAgeGreaterThanAndJoiningYearInAndAgeBefore(age, joiningYear );
    }
    public Optional<Users> getAge(Integer age){
       return userRepository.findAllByAgeGreaterThan(age);
    }
    public Integer countAllByRole(String role){
        return userRepository.countAllByRole(role);

    }
    public Boolean findUsersByUsernameAndPassword(String username, String password){
        return userRepository.findUsersByUsernameAndPassword(username,password);
    }
    public Users getEmail(String email){
        return userRepository.findUsersByEmail(email);

    }
//

}
