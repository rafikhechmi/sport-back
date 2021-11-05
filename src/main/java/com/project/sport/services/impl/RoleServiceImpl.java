package com.project.sport.services.impl;

import com.project.sport.models.Role;
import com.project.sport.models.enums.RoleEnum;
import com.project.sport.repositories.RoleRepository;
import com.project.sport.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(RoleEnum name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void createIfNotExist(RoleEnum value) {
        Role existingRole = roleRepository.findByName(value);
        if (existingRole == null) {
            roleRepository.save(new Role(value));
        }
    }

}
