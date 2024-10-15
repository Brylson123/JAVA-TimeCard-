package com.example.timelog_api.controller;

import com.example.timelog_api.domain.User;
import com.example.timelog_api.service.LoginService;
import com.example.timelog_api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    public UserController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/createUser")
    @ResponseBody
    boolean createUser(@RequestBody User user) {
        System.out.println(user);
        return userService.CreateUser(user);
    }

    @PostMapping("/login/{cardNumber}")
    @ResponseBody
    User login(@PathVariable String cardNumber) {
        return loginService.login(cardNumber);
    }
}
