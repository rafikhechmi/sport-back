package com.project.sport.services.impl;

import com.project.sport.models.Role;
import com.project.sport.models.User;
import com.project.sport.models.enums.RoleEnum;
import com.project.sport.repositories.UserRepository;
import com.project.sport.services.RoleService;
import com.project.sport.services.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User add(User user) {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        if (CollectionUtils.isEmpty(user.getRoles())) {
            Role userRole = Optional.ofNullable(roleService.findByName(RoleEnum.USER)).orElseGet(() -> new Role(RoleEnum.USER));
            user.setRoles(Collections.singletonList(userRole));
        }
        return userRepository.save(user);
    }

    @Override
    public void createAdminIfNotExist() {
        final String adminFirstName = "rafik";
        final String adminLastNAme = "hechmi";
        final String adminPassword = bCryptPasswordEncoder.encode("123456");
        final String adminEmail = "rafikhechmi@gmail.com";
        final Role adminRole = roleService.findByName(RoleEnum.ADMIN);
        List<User> existingUsers = userRepository.findAllByEmailAndRoleName(adminEmail, RoleEnum.ADMIN);
        if (CollectionUtils.isEmpty(existingUsers)) {
            userRepository.save(new User(null, adminFirstName, adminLastNAme, adminEmail, adminPassword, Collections.singletonList(adminRole)));
        }
    }

}
