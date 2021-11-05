package com.project.sport.controllers;

import com.project.sport.models.User;
import com.project.sport.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User create(@RequestBody User user) {
        return userService.add(user);
    }

}