package com.project.sport.startup;

import com.project.sport.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class UserRunner implements CommandLineRunner {

    private final UserService userService;

    public UserRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createAdminIfNotExist();
    }
}
