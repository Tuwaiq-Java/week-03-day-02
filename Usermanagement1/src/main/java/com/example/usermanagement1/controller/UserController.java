package com.example.usermanagement1.controller;

import com.example.usermanagement1.model.User;
import com.example.usermanagement1.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUser(){

        return ResponseEntity.status(200).body(userService.getUser());
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){

        return ResponseEntity.status(200).body(userService.getUserById(id));
    }
    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){

        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }
    @GetMapping("/age")
    public ResponseEntity<List<User>> getUserByAgeOlder(@RequestParam String age){

        return ResponseEntity.status(200).body(userService.getUserByAgeOlder(age));
    }
    @GetMapping("/role")
    public ResponseEntity<Integer> getTotalRole(@RequestParam String role){

        return ResponseEntity.status(200).body(userService.getTotalRole(role));
    }
    @GetMapping("/user-pass")
    public ResponseEntity checkUsernameAndPass(@RequestParam String username,@RequestParam String pass){

        return ResponseEntity.status(200).body( userService.checkUsernameAndPass(username, pass));
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @RequestParam String id, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }

        userService.updateuser(user,id);
        return ResponseEntity.status(200).body("user updated");
    }
    @PutMapping("/update-pass")
    public ResponseEntity updateUserPassword(@RequestParam String id,@RequestParam String newpassword, Errors errors){


        userService.updateUserPassword(id,newpassword);
        return ResponseEntity.status(200).body("user updated");
    }

    @GetMapping("/join-year")
    public ResponseEntity<User> checkUserYearJoin(@RequestParam String id,@RequestParam String year){

        return ResponseEntity.status(200).body( userService.checkUserYearJoin(id, year));
    }
    @GetMapping("/all-user")
    public ResponseEntity<List<User>> checkAllUserYearJoin(@RequestParam String year){

        return ResponseEntity.status(200).body( userService.getAllUserYearJoin( year));
    }
    @GetMapping("/age-year")
    public ResponseEntity<List<User>> getByageAndYearJoin(@RequestParam String age,@RequestParam String year){

        return ResponseEntity.status(200).body( userService.getByageAndYearJoin( age,year));
    }



    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body("user added");
    }

}
