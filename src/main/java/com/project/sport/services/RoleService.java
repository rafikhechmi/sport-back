package com.project.sport.services;

import com.project.sport.models.Role;
import com.project.sport.models.enums.RoleEnum;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role findByName(RoleEnum name);

    void createIfNotExist(RoleEnum value);
}
