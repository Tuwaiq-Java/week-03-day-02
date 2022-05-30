package com.example.exerw3d2.services;

import com.example.exerw3d2.model.Users;
import com.example.exerw3d2.repository.Userrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Userservice {

    private  final Userrepo userrepo;

    public List<Users> getuser(){
        return userrepo.findAll();
    }
    public Users getuserbyid(Integer id){
        return userrepo.findById(id).get();}

    public Users getuserbyemail(String email){
        return userrepo.findByEmailEquals(email);}

public List<Users> getagegreater(Integer age){
        return userrepo.findByAgeGreaterThan(age);}

    public Integer getcountrole(String role){
        return userrepo.countByRole(role);

    }

    public String check(String username,String pass){
        Users checkuser= userrepo.findAllByUsernameEqualsAndPasswordEquals(username, pass);
        if(checkuser!=null){
      return "data is correct";}
    return "false";}

    public void ubdate(Integer id,Users newuser){
        Users olduser=  userrepo.findById(id).get();
      if(newuser.getRole().equals("admin")){
          olduser.setAge(newuser.getAge());
          olduser.setEmail(newuser.getEmail());
          olduser.setPassword(newuser.getPassword());
          olduser.setUsername(newuser.getUsername());
          userrepo.save(olduser);
      }
    }

    //public Users getstudentname(String name){
      //  return userrepo.findByUsername(name);}
public String updatepassword(Integer id,String password){
        Users user=  userrepo.findAllById(id);
        if(user.getId()!=null){
            user.setPassword(password);
            userrepo.save(user);
            return "password is updated";}
        return "id is not correct";}

    public void adduser(Users users){
        userrepo.save(users);}

    public  Users checkyear(Integer id, String year){
        return userrepo.checkyear(id,year);
    }

    public List<Users> ageandyear(Integer age, String year){

        return userrepo.getageyear(age,year);
    }

    public List<Users> alluserinyear(String year){
        return userrepo.getalluserinyear(year);
    }
}
