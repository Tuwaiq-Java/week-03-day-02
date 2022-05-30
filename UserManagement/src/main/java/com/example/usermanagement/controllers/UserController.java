package com.example.usermanagement.controllers;

import com.example.usermanagement.models.MyUsers;
import com.example.usermanagement.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserServices userServices;

    @GetMapping("/")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userServices.getUsers());
    }
    @PostMapping("/")
    public ResponseEntity addUser(@RequestBody @Valid MyUsers user, Errors error){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        userServices.addUser(user);
        return ResponseEntity.status(201).body("Successfully added user");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id){
        MyUsers user = userServices.getUserById(id);
        if(user != null){
            return ResponseEntity.status(200).body(user);
        }
        return ResponseEntity.status(400).body("Invalid Id");
    }
    @GetMapping("/age/{age}")
    public ResponseEntity getUserByAge(@PathVariable Integer age){
        List<MyUsers> users = userServices.getUserByAge(age);
        if(users != null){
            return ResponseEntity.status(200).body(users);
        }
        return ResponseEntity.status(400).body("None found");
    }
    @GetMapping("/role/{role}")
    public ResponseEntity getUserCountByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(userServices.getUserByRole(role));
    }

    @GetMapping("/auth")
    public ResponseEntity authenticateUser(@RequestParam String username,@RequestParam String password){
        if(userServices.authenticateUser(username, password)){
            return ResponseEntity.status(200).body("Successfully authenticated!");
        }
        return ResponseEntity.status(400).body("password or username is incorrect");
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateUser(@RequestBody @Valid MyUsers user, Errors error, @PathVariable Integer userId){
        if(error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        if(userServices.updateUser(user,userId)){
            return ResponseEntity.status(201).body("Successfully updated!");
        }
        return ResponseEntity.status(400).body("user is not an admin or invalid id");
    }
    @PutMapping("/update/password/{userId}")
    public ResponseEntity updateUserPassword(@RequestBody String password, @PathVariable Integer userId){

        if(userServices.updateUserPassword(userId, password)){
            return ResponseEntity.status(201).body("Successfully updated password!");
        }
        return ResponseEntity.status(400).body("invalid id");
    }

    @GetMapping("/year/{year}")
    public ResponseEntity checkYear(@RequestParam Integer userId, @PathVariable String year){
        Integer checkStatus = userServices.checkYear(userId,year);
        if(checkStatus == 0){
            return ResponseEntity.status(200).body("Correct year entered");
        } else if (checkStatus ==1) {
            return ResponseEntity.status(400).body("incorrect year entered");
        }
        return ResponseEntity.status(400).body("Invalid id");
    }
    @GetMapping("/joinYear/{year}")
    public ResponseEntity getUsersByJoinYear(@PathVariable String year){
        if(userServices.getUsersByYear(year).size() == 0){
            return ResponseEntity.status(400).body("None found");
        }
        return ResponseEntity.status(200).body(userServices.getUsersByYear(year));
    }
    @GetMapping("/ageYear/{year}")
    public ResponseEntity getUsersByJoinYear(@PathVariable String year, @RequestParam Integer age){
        if(userServices.getUsersByAgeAndYear(year, age).size() == 0){
            return ResponseEntity.status(400).body("None found");
        }
        return ResponseEntity.status(200).body(userServices.getUsersByAgeAndYear(year, age));
    }

}
