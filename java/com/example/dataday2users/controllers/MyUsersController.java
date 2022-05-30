package com.example.dataday2users.controllers;

import com.example.dataday2users.model.MyUsers;
import com.example.dataday2users.services.MyUsersService;
import lombok.AllArgsConstructor;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class MyUsersController {

    private final MyUsersService myUsersService;

    @GetMapping
    public ResponseEntity getUser(){
        return ResponseEntity.status(201).body(myUsersService.getUsers());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody MyUsers myUsers, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        myUsersService.addUsers(myUsers);
        return ResponseEntity.status(200).body("User Added");
    }

    @GetMapping("/{userid}")
    public ResponseEntity<MyUsers> getUserById(@PathVariable Integer userid){

        return ResponseEntity.status(200).body(myUsersService.getUserById(userid));
    }

    @GetMapping("/{email}")
    public ResponseEntity<MyUsers> getUserByEmail(@PathVariable String email){

        return ResponseEntity.status(200).body(myUsersService.getUserByEmail(email));
    }

    @GetMapping("/{age}")
    public ResponseEntity<List<MyUsers>> getUserOlderAge(@PathVariable Integer age){

        return ResponseEntity.status(200).body(myUsersService.getUserByOlderAge(age));
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<MyUsers>> countAllByRole(@PathVariable String role){

        return ResponseEntity.status(200).body(myUsersService.countAllByRole(role));
    }

    @GetMapping("/iscorrect")
    public ResponseEntity<List<MyUsers>> getIsFind(@RequestBody String username ,@RequestBody String pass){

        return ResponseEntity.status(200).body(myUsersService.isFind(username,pass));
    }

    @GetMapping("/update/{userid}/myUsers")
    public ResponseEntity updateAdmin(@PathVariable Integer userid, @PathVariable MyUsers myUsers ,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        myUsersService.updateAdmin(userid, myUsers);
        return ResponseEntity.status(200).body("Admin is updated");
    }

    @GetMapping("update/{userid}")
    public ResponseEntity updatePass(@PathVariable Integer userid,MyUsers myUsers){
        myUsersService.updatePass(userid, myUsers);
        return ResponseEntity.status(200).body("Password is updated");
    }

    @GetMapping("/joining/{year}/{userid}")
    public ResponseEntity findByIdAndJoiningYearEquals(@PathVariable String year, @PathVariable Integer userid) {
        return ResponseEntity.status(200).body(myUsersService.findByIdAndJoiningYearEquals(userid, year));
    }


    @GetMapping("/joining/{year}")
    public ResponseEntity<List<MyUsers>> findByJoiningYear(@PathVariable String year) {
        return ResponseEntity.status(200).body(myUsersService.joiningYear(year));
    }

    @GetMapping("/joining/{year}/{age}")
    public ResponseEntity<List<MyUsers>> findJoiningYearAndAge(@PathVariable String year,@PathVariable Integer age) {
        return ResponseEntity.status(200).body(myUsersService.ageAndJoining(age,year));
    }

}
