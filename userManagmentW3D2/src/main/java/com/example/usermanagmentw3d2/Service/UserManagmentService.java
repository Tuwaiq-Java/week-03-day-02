package com.example.usermanagmentw3d2.Service;


import com.example.usermanagmentw3d2.Repository.UserManagmentRepository;
import com.example.usermanagmentw3d2.model.UserManagment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagmentService {

private final UserManagmentRepository userManagmentRepository;


    public List<UserManagment>getUsers() {
        return userManagmentRepository.findAll();
    }

    public void addUser(UserManagment userManagment) {
         userManagmentRepository.save(userManagment);
    }

    public List<UserManagment> getUsersById(Integer id){
        return userManagmentRepository.findAllById(id);
    }

    public UserManagment getUserByEmail(String email){
        return userManagmentRepository.findByEmail(email);
    }

    public UserManagment getUserByGreaterAge(String age){
        return userManagmentRepository.findByAge(age);

    }

    public UserManagment getRoleCount(String role){
        return userManagmentRepository.findByRoleCount(role);


    }

    public UserManagment getUsername(String username){
        return userManagmentRepository.findByUsername(username);
    }



    public UserManagment getPassword(String password){
        return userManagmentRepository.findByPassword(password);
    }







   public UserManagment checkPassAndUsername(String username , String password){
        UserManagment usern = getUsername(username);
        UserManagment userp = getPassword(password);

        if(!usern.equals(getUsername(username)) || userp.equals(getPassword(password))){
            ResponseEntity.status(400).body("wrong password or username");

        }
        return usern;
   }










}
