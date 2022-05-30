package com.example.usersystem.controller;

import com.example.usersystem.model.User;
import com.example.usersystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }
    @GetMapping("/getuserid/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userid){
        return ResponseEntity.status(200).body(userService.findUserById(userid));
    }
    @GetMapping("/getuseremail/{email}")
    public ResponseEntity<User> getUserById(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.findUserByEmail(email));
    }
    @GetMapping("/getuserage/{age}")
    public ResponseEntity<List<User>> findUserByAgeGreaterThanEqual(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.findUserByAgeGreaterThanEqual(age));
    }
    @GetMapping("/getuserrole/{role}")
    public ResponseEntity<Integer> getRoles(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.getRoles(role));
    }
    @GetMapping("/checkuser/{username}/{password}")
    public ResponseEntity checkUsers(@PathVariable String username,@PathVariable String password){
        if (!userService.checkUsers(username,password)){
            return ResponseEntity.status(400).body("Wrong username or password");
        }
        return ResponseEntity.status(201).body("Correct username and password");
    }
    @GetMapping("/ageandyear/{age}/{joiningYear}")
    public ResponseEntity<List<User>> ageAndJoinintgYear(@PathVariable Integer age,@PathVariable String joiningYear){
        return ResponseEntity.status(201).body(userService.ageAndJoinintgYear(age,joiningYear));
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if(userService.updateUser(user,id)){
            return ResponseEntity.status(200).body("User update");
        }
        return ResponseEntity.status(400).body("User doesn't exist");

    }
    @PutMapping("update/{id}/{password}")
    public ResponseEntity updatePassword(@PathVariable Integer id,@PathVariable String password){
        if(userService.updatePassword(id,password)){
            return ResponseEntity.status(201).body("Password Updated");
        }
        return ResponseEntity.status(400).body("User not found");
    }
    @GetMapping("join/{joiningYear}/{id}")
    public ResponseEntity checkJoinYear(@PathVariable String joiningYear,@PathVariable Integer id){
         if(userService.checkJoinYear(joiningYear,id))
             return ResponseEntity.status(201).body("User joined that year");

         return ResponseEntity.status(400).body("User didn't join that year");
     }
     @GetMapping("/useryear/{joiningYear}")//
    public ResponseEntity<List<User>> getUsersByJoiningYear(@PathVariable String joiningYear){
        return ResponseEntity.status(200).body(userService.getUsersByJoiningYear(joiningYear));
     }
    }

