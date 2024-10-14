package com.example.timelog_api.controller;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ResponseBody
    boolean createUser(@RequestBody User user) {
        System.out.println(user);
        return userService.CreateUser(user);
    }
}
