package com.example.week3day2.Controller;

import com.example.week3day2.Model.User;
import com.example.week3day2.Service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

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
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors error){
        if(error.hasFieldErrors()){
            String err=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(err);
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body("User added");
    }
    @GetMapping({"{user_id}"})
    public ResponseEntity getUserById(@PathVariable Integer user_id){
        return ResponseEntity.status(200).body(userService.getUser(user_id));
    }
    @GetMapping("e/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }
    @GetMapping("age")
    public ResponseEntity getUsersOlderthan(@RequestParam Integer age){
        return ResponseEntity.status(200).body(userService.getUsersByAgeGreaterThan(age));
    }
    @GetMapping("count")
    public ResponseEntity countByRole(@RequestParam String role){
        return ResponseEntity.status(200).body("Number of "+role+" : "+userService.getUsersNumByRole(role));
    }
    @GetMapping("login")
    public ResponseEntity checkLogin(@RequestParam String username,@RequestParam String password){
        return ResponseEntity.status(200).body(userService.checkLogin(username,password));
    }
    @PutMapping("{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors error){
        if(error.hasFieldErrors()){
            String err=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(err);
        }
        Boolean isUpdated=userService.updateUser(id,user);
        if(!isUpdated){
            return ResponseEntity.status(400).body("User not updated");
        }
        return ResponseEntity.status(201).body("User Updated");
    }
    @PutMapping()
    public ResponseEntity updatePassword(@RequestParam Integer id,@RequestParam String password){
        userService.updatePassword(password,id);
        return ResponseEntity.status(200).body("Password updated");
    }
    @GetMapping("joined")
    public  ResponseEntity hasJoined(@RequestParam Integer id, @RequestParam LocalDate joiningyear){
       Boolean Joined= userService.hasJoinedIn(joiningyear,id);
        return ResponseEntity.status(200).body(Joined);
    }
    @GetMapping("joined/all")
    public ResponseEntity getUsersByJoiningYear(@RequestParam LocalDate joiningYear ){
        return ResponseEntity.status(200).body(userService.getUsersByJoiningYear(joiningYear));
    }
    @GetMapping("joined/{age}")
    public ResponseEntity getUsersByAgeandJoiningYear(@PathVariable Integer age,@RequestParam LocalDate joiningYear){
        return ResponseEntity.status(200).body(userService.getUsersByAgeandJoiningYear(age,joiningYear));
    }
}
