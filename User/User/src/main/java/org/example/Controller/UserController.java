package org.example.Controller;

import org.bson.types.ObjectId;
import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*",allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public User register(@RequestBody User user){
        User res=userService.register(user);
        return res;

    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        return userService.userLogin(userEmail, userPassword);
    }
    @GetMapping("/get_user")
    public List<User> getallmovie(){
        return userService.save();
    }

}
