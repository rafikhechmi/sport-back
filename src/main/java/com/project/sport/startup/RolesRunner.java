package com.project.sport.startup;

import com.project.sport.models.enums.RoleEnum;
import com.project.sport.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RolesRunner implements CommandLineRunner {

    private final RoleService roleService;

    public RolesRunner(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (RoleEnum value : RoleEnum.values()) {
            roleService.createIfNotExist(value);
        }
    }

}
