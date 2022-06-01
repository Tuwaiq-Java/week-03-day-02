package com.example.usersmanagement.controller;

import com.example.usersmanagement.model.User;
import com.example.usersmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody  User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getUserId(@PathVariable Integer userid){

        return ResponseEntity.status(200).body(userService.getUserId(userid));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserEmail(@PathVariable String email){

        return ResponseEntity.status(200).body(userService.getUserEmail(email));
    }
    @GetMapping("/{age}")
    public ResponseEntity<List<User>> getUserOlder(@PathVariable Integer age){

        return ResponseEntity.status(200).body(userService.getUserOlder(age));
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<User>> getRole(@PathVariable String role){

        return ResponseEntity.status(200).body(userService.getRole(role));
    }

    @GetMapping("/check")
    public ResponseEntity<List<User>> check(@RequestBody String username ,@RequestBody String password){
        return ResponseEntity.status(200).body(userService.check(username,password));
    }

    @GetMapping("/update/{userid}/user")
    public ResponseEntity updateUser(@PathVariable Integer userid, @PathVariable User user ,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(userid, user);
        return ResponseEntity.status(200).body("User is updated");
    }
    @GetMapping("update/{userid}")
    public ResponseEntity updatePassword(@PathVariable Integer userid,User user){
        userService.updatePassword(userid, user);
        return ResponseEntity.status(200).body("Password is updated");
    }

    @GetMapping("/joining/{year}/{userid}")
    public ResponseEntity joiningYearAndUserId(@PathVariable String year, @PathVariable Integer userid) {
        return ResponseEntity.status(200).body(userService.joiningYearUserId(userid, year));
    }


    @GetMapping("/joining/{year}")
    public ResponseEntity<List<User>> JoiningYear(@PathVariable String year) {
        return ResponseEntity.status(200).body(userService.joiningYear(year));
    }

    @GetMapping("/joining/{year}/{age}")
    public ResponseEntity<List<User>> joiningYearAndAge(@PathVariable String year,@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.ageAndJoining(age,year));
    }
}
