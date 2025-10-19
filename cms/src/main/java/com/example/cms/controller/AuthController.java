package com.example.cms.controller;

import com.example.cms.entity.User;
import com.example.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest){
        return userService.loginUser(loginRequest.getEmail(),loginRequest.getPassword());
    }
}
