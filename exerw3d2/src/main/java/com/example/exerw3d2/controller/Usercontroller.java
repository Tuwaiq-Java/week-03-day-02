package com.example.exerw3d2.controller;

import com.example.exerw3d2.model.Users;
import com.example.exerw3d2.services.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class Usercontroller {

private final Userservice userservice;

    @GetMapping
    public ResponseEntity getuser() {
        return ResponseEntity.status(200).body(userservice.getuser());
    }

    @GetMapping("id/{id}")
    public ResponseEntity getuserbyid(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(userservice.getuserbyid(id));}

    @GetMapping("/{email}")
    public ResponseEntity getuserbyemail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userservice.getuserbyemail(email));}

    @GetMapping("age/{age}")
    public ResponseEntity getuserbyage(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userservice.getagegreater(age));}

    @GetMapping("role/{role}")
    public ResponseEntity<Integer> getuserbyrole(@PathVariable String role) {
        Integer count=userservice.getcountrole(role);
        return ResponseEntity.status(200).body(count);}

    @GetMapping("check")
    public ResponseEntity check(@RequestParam String username,@RequestParam String userpassword) {
     // String check=  userservice.check(username,pass);
        return ResponseEntity.status(200).body(userservice.check(username,userpassword));}

    @PostMapping
    public ResponseEntity adduser(@RequestBody @Valid Users user, Errors errors) {

        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userservice.adduser(user);
        return ResponseEntity.status(200).body("the user is added");

    }
    @PutMapping("update/{id}")
    public ResponseEntity Uupdate(@PathVariable Integer id,@RequestBody Users users){

        userservice.ubdate(id,users);
        return ResponseEntity.status(200).body("the user is updated");}

    @PutMapping("updatpass")
    public ResponseEntity updatepassword(@RequestParam Integer id,@RequestParam String password){

        return ResponseEntity.status(200).body( userservice.updatepassword(id,password));
    }

    @GetMapping ("checkjoinyear")
    public ResponseEntity checkyear (@RequestParam Integer id,@RequestParam String year){

        return ResponseEntity.status(200).body(userservice.checkyear(id,year));
    }

    @GetMapping ("userwithageinyear")
    public ResponseEntity checkyearage (@RequestParam Integer age,@RequestParam String year){

        return ResponseEntity.status(200).body(userservice.ageandyear(age,year));
    }

    @GetMapping ("alluserinyear")
    public ResponseEntity alluserinyear (@RequestParam String year){

        return ResponseEntity.status(200).body(userservice.alluserinyear(year));
    }



}
