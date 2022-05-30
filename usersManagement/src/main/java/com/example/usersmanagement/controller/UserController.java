package com.example.usersmanagement.controller;

import com.example.usersmanagement.model.User;
import com.example.usersmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
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

    @GetMapping("/getUserWithId/{id}")
    public ResponseEntity<User> getUserWithID(@PathVariable String id) {
        return ResponseEntity.status(200).body(userService.getUserWithID(id));
    }

    @GetMapping("/getUserWithEmail/{email}")
    public ResponseEntity<User> getUserWithEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.getUserWithEmail(email));
    }

    @GetMapping("/getUserOlderThan/{age}")
    public ResponseEntity<List<User>> getUserOlderThan(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.getUserOlderThan(age));
    }

    @GetMapping("/totalCountOfRole/{role}")
    public ResponseEntity<Integer> getTotalCountOfRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getTotalCountOfRole(role));
    }

    @GetMapping("/getUsersByJoiningDate/{date}")
    public ResponseEntity<List<User>> getUsersByJoiningDate(@PathVariable Date date) {
        return ResponseEntity.status(200).body(userService.getUsersByJoiningDate(date));
    }

    @GetMapping("/getUsersByAgeEqualsAndJoiningDateAfter")
    public ResponseEntity<List<User>> getUsersByAgeEqualsAndJoiningDateAfter(@RequestParam Date date, @RequestParam Integer age) {
        return ResponseEntity.status(200).body(userService.getUsersByAgeEqualsAndJoiningDateAfter(date,age));
    }

    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestParam String username, @RequestParam String password) {
        Integer status=userService.checkLogin(username,password);
        if (status ==1 )
            return ResponseEntity.status(200).body("Welcome back");
        return ResponseEntity.status(400).body("Failed to login");
    }

    @PutMapping("/updateWithAdmin/{userid}")
    public ResponseEntity<String> updateWithAdminCreds(@PathVariable String userid,@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        Integer status= userService.updateWithAdmin(userid,user);
        if (status ==1) {
            return ResponseEntity.status(200).body("User Updated!");
        }
        return ResponseEntity.status(400).body("userid not admin!");
    }

    @PutMapping("/changePassword/")
    public ResponseEntity<String> updatePassword(@RequestParam String userid, @RequestParam String password) {
        Integer status = userService.changePassword(userid, password);
        if (status == 1) {
            return ResponseEntity.status(200).body("User Changed Password!");
        }

        return ResponseEntity.status(400).body("userid not Found");
    }

    @GetMapping("/joiningYear/")
    public ResponseEntity<String> checkJoiningYear(@RequestParam String userid, @RequestParam String joiningYear) {
        Integer status = userService.checkJoiningYear(userid, joiningYear);
        if (status == 1) {
            return ResponseEntity.status(200).body("User Joined with given year!");
        }

        return ResponseEntity.status(400).body("user didn't join with given year");
    }



    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        userService.addUser(user);
        return ResponseEntity.status(201).body("User Added !");
    }


}
