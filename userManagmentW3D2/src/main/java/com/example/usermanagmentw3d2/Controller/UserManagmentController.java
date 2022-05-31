package com.example.usermanagmentw3d2.Controller;


import com.example.usermanagmentw3d2.Service.UserManagmentService;
import com.example.usermanagmentw3d2.model.UserManagment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/userman")
@RequiredArgsConstructor
public class UserManagmentController {

    private final UserManagmentService userManagmentService;





    @GetMapping
    public ResponseEntity<List<UserManagment>> getUser(){
        return ResponseEntity.status(200).body(userManagmentService.getUsers());


    }


    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserManagment userManagment, Errors errors){
        if (errors.hasErrors())
        {
            ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }

        userManagmentService.addUser(userManagment);
        return ResponseEntity.status(201).body("user added");
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<UserManagment>> getUsersById(@RequestParam Integer id){
        return ResponseEntity.status(200).body(userManagmentService.getUsersById(id));

    }



    @GetMapping("/email")
    public ResponseEntity<UserManagment> getUserByEmail(@RequestParam String email){
        return ResponseEntity.status(200).body(userManagmentService.getUserByEmail(email));

    }



    @GetMapping("/age")
    public ResponseEntity<UserManagment> getUserByGreaterAge(@RequestParam String age) {
        return ResponseEntity.status(200).body(userManagmentService.getUserByGreaterAge(age));

    }

//**
    @GetMapping("/role")
    public ResponseEntity<UserManagment> getRoleCount(@RequestParam String role){
        return ResponseEntity.status(200).body(userManagmentService.getRoleCount(role));
    }





    }
