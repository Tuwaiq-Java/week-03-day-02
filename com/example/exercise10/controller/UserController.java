package com.example.exercise10.controller;

import com.example.exercise10.model.User;
import com.example.exercise10.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<?> addUsers(@RequestBody @Valid User user){
        userService.addUsers(user);
        return ResponseEntity.status(200).body("Users added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/age")
    public ResponseEntity<?> getUserByOlderAge(@RequestParam Integer age){
        return ResponseEntity.status(200).body(userService.getUserByOlderAge(age));
    }

    @GetMapping("/role")
    public ResponseEntity<?> getCountOfRole(@RequestParam String role){
        return ResponseEntity.status(200).body(userService.getCountOfRole(role));
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkUsernameAndPass(@RequestParam String username,
                                            @RequestParam String password){
        return ResponseEntity.status(200).body(userService.checkUsernameAndPass(username,password));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUsers(@RequestBody @Valid User user, @PathVariable Integer id){
        userService.updateUser(id,user);
        return ResponseEntity.status(200).body("User updated!");
    }

    @PutMapping("/{userId}/{password}")
    public ResponseEntity<?> updatePassword(@PathVariable String password, @PathVariable Integer id){
        userService.updatePassword(password,id);
        return ResponseEntity.status(200).body("Password updated!");
    }

    @GetMapping("/date")
    public ResponseEntity<?> checkJoiningYear(@RequestParam Integer id,
                                                  @RequestParam Integer joiningYear){
        return ResponseEntity.status(200).body(userService.checkJoiningYear(id,joiningYear));
    }

    @GetMapping("/dateAfter")
    public ResponseEntity<?> checkJoiningYearUsers(@RequestParam Integer joiningYear){
        return ResponseEntity.status(200).body(userService.checkJoiningYearUsers(joiningYear));
    }

    @GetMapping("/age/date")
    public ResponseEntity<?> checkJoiningYearAndAge(@RequestParam Integer age,@RequestParam Integer joiningYear){
        return ResponseEntity.status(200).body(userService.checkJoiningYearAndAge(age,joiningYear));
    }


}
