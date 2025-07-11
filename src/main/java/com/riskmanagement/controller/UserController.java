package com.riskmanagement.controller;

import com.riskmanagement.dto.LoginRequestDTO;
import com.riskmanagement.entity.UserEntity;
import com.riskmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO user){
        return userService.verify(user);
    }
    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        return userService.register(user);
    }
}
