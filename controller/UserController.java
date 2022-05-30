package com.example.usersmanagement.controller;

import com.example.usersmanagement.model.Users;
import com.example.usersmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity<Api> addUsers(@RequestBody @Valid Users users, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isAddUsers = userService.addUsers(users);
        if (!isAddUsers){
            return ResponseEntity.status(400).body(new Api("Sorry but your request inValued :(",400));
        }
        return ResponseEntity.status(201).body(new Api("your request Valued :) ",201));
    }
    // endpoint that takes users id and return the user with this id
    @GetMapping("/{id}")
        public ResponseEntity<Optional<Users>> getUsersbyId(@PathVariable Long id){
        Optional isgetUserbyId =  userService.getUsersbyId(id);
        return ResponseEntity.status(200).body(userService.getUsersbyId(id));
    }
    // endpoint that takes email and return the user with this email
    @GetMapping("/email")
    public ResponseEntity<Optional<Users>> getUsersbyEmail(@RequestParam String email){
        Optional isgetUserbyEmail =  userService.getUsersbyEmail(email);
        return ResponseEntity.status(200).body(userService.getUsersbyEmail(email));
    }
    // endpoint that takes age and return the user with older than this age
    @GetMapping("/age")
    public ResponseEntity<List<Users>> getUsersbyAge(@RequestParam Integer age){
        return ResponseEntity.status(200).body(userService.getUsersbyAge(age));
    }
    // endpoint that takes role and return the total count having this role
    @GetMapping("/role")
    public ResponseEntity<Long> getUsersbyRole(@RequestParam String role){
        Long isgetUserbyRole =  userService.getUsersbyRole(role);
        return ResponseEntity.status(200).body(userService.getUsersbyRole(role));
    }
    // endpoint that takes username and password and check if it's correct or not
    @GetMapping("/login")
    public ResponseEntity getCheck(@RequestParam String username,@RequestParam String password){
       boolean isgetCheck = userService.getCheck(username,password);
        if (!isgetCheck){
            return ResponseEntity.status(400).body(new Api("Sorry but your request inValued :(",400));
        }
        return ResponseEntity.status(200).body(userService.getCheck(username,password));
    }
    // endpoint that takes userid and user object , update the olduser object with the new object after verifying the userid belong to admin user
    @PutMapping
    public ResponseEntity<Api> editUsers(@RequestBody Users users, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isEditUsers = userService.editUsers(users);
        if (!isEditUsers){
            return ResponseEntity.status(400).body(new Api("Sorry but your request inValued :(",400));
        }
        return ResponseEntity.status(201).body(new Api("your request Valued :) ",201));
    }
    //takes newPassword and userid , update the olduser password with the new Password
    @PutMapping("/pwd")
    public ResponseEntity<Api> editUsersPwd(@RequestBody Users users, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isEditUsers = userService.editUsersPwd(users);
        if (!isEditUsers){
            return ResponseEntity.status(400).body(new Api("Sorry but your request inValued :(",400));
        }
        return ResponseEntity.status(201).body(new Api("your request Valued :) ",201));
    }
    //takes joiningYear and userid , and return if this user joined with the date that being sent or not
    @GetMapping("/date")
    public ResponseEntity<Long> getUsersbyDate(@RequestParam String joiningYear){
        Long isgetUsersbyDate =  userService.getUsersbyDate(Integer.valueOf(joiningYear));
        return ResponseEntity.status(200).body(userService.getUsersbyDate(Integer.valueOf(joiningYear)));
    }
    //endoiunt that takes joiningYear and return all the users who joined in this date or after
    @GetMapping("/date-start")
    public ResponseEntity<List<Users>> getUsersbyDateStart(@RequestParam Integer joiningYear){
        return ResponseEntity.status(200).body(userService.getUsersbyAge(joiningYear));
    }
    // endoiunt that takes age and joiningYear and return all the users who joined in this date or before and all have the same age
    @GetMapping("/date-age")
    public ResponseEntity<List<Users>> getUsersbyDateAndAge(@RequestParam Integer age,@RequestParam Integer joiningYear){
        return ResponseEntity.status(200).body(userService.getUsersbyDateAndAge(age,joiningYear));
    }
}
