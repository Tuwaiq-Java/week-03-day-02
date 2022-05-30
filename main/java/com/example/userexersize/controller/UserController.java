package com.example.userexersize.controller;

import com.example.userexersize.model.User;
import com.example.userexersize.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(userService.addUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.getUserByID(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<User> getUserOlder(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.getUserOlder(age));
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<Integer> countOfUserByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(userService.countOfUserByRole(role));
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkUsernamePassword(@RequestParam String username, @RequestParam String password){
        return ResponseEntity.status(200).body(userService.checkUsernamePassword(username,password));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(userService.updateUser(id,user));
    }
    @PutMapping
    public ResponseEntity<String> newPassword(@RequestParam Integer id, @RequestParam String newPassword){
        return ResponseEntity.status(200).body(userService.newPassword(id,newPassword));
    }

    @GetMapping("/joiningYear")
    public ResponseEntity<String> checkUserJoiningYear(@RequestParam Integer id, @RequestParam String joiningYear){
        return ResponseEntity.status(200).body(userService.checkUserJoiningYear(id,joiningYear));
    }
    @GetMapping("/joiningYearAfter")
    public ResponseEntity<Optional<User>> userJoiningYear(@RequestParam String joiningYear){
        return ResponseEntity.status(200).body(userService.userJoiningYear(joiningYear));
    }

    @GetMapping("/joiningYear/age")
    public ResponseEntity<Object> userJoiningYearAndAge(@RequestParam String joiningYear, @RequestParam Integer age){
        return ResponseEntity.status(200).body(userService.userJoiningYearAndAge(joiningYear,age));
    }



}
