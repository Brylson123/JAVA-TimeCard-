package com.example.timelog_api.controller;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
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
