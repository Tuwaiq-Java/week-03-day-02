package com.example.users.Controller;


import com.example.users.Models.Users;
import com.example.users.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid Users users, Errors error){
        if (error.hasErrors()){
            return ResponseEntity.status(200).body(error.getFieldError().getDefaultMessage());
        }
        usersService.addUser(users);
        return  ResponseEntity.status(200).body("added new user");
    }
    @GetMapping("/getUser")
    public ResponseEntity<Users> getUserById(String id){
        return ResponseEntity.status(200).body(usersService.findUsersById(id));
    }
    @PutMapping("/email")
    public ResponseEntity<Users> getByEmail(@RequestParam String email){
        return ResponseEntity.status(200).body(usersService.getEmail(email));
    }
    @GetMapping("/getage")
    public ResponseEntity<Optional<Users>> ageOlder(@RequestParam Integer age){
        return ResponseEntity.status(200).body(usersService.getAge(age));
    }
    @GetMapping("/getRole")
    public ResponseEntity getconutrole(@RequestParam String role){
        return ResponseEntity.status(200).body(usersService.countAllByRole(role));
    }
    @GetMapping("/checkusernamepassword")
    public ResponseEntity checkusername(@RequestParam String pssword,@RequestParam String username){
        if (usersService.findUsersByUsernameAndPassword(username,pssword))
            return ResponseEntity.status(200).body("correct");
        return ResponseEntity.status(400).body("not correct");

    }
    @PutMapping("/update")
    public ResponseEntity updateAndcheck(@RequestParam String id,@RequestBody Users users){
        if( usersService.updateUserById( users,id))
            return  ResponseEntity.status(200).body("update the user");
        return  ResponseEntity.status(400).body(" can't update the user");
    }
    @PutMapping("/password")
    public ResponseEntity updateUserByPassword(@RequestParam String id, @RequestParam String password) {
      if (usersService.updateUserByPassword(id,password))
          return ResponseEntity.status(200).body("update it ");
        return ResponseEntity.status(400).body("can't update it ");

    }
    @GetMapping("/getyear")
    public ResponseEntity checkYear(@RequestParam String id,@RequestParam Integer JoiningYear){
        if(usersService.checkJoiningYear(id,JoiningYear))
            return ResponseEntity.status(200).body("yes");
        return ResponseEntity.status(400).body("No");

    }
    @GetMapping("/ageAndyear")
    public ResponseEntity<Optional<Users>> findUsersByAgeAndYear (@RequestParam Integer age, @RequestParam Integer joiningYear ){
        return ResponseEntity.status(200).body(usersService.findUsersByAgeAndYear(age,joiningYear));
    }
    @GetMapping("year")
    public ResponseEntity<Optional<Users>> findUsersByYear (@RequestParam Integer joiningYear ){
        return ResponseEntity.status(200).body(usersService.findUsersByYear(joiningYear));
    }





}
