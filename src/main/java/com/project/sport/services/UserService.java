package com.project.sport.services;

import com.project.sport.models.User;

public interface UserService {

    User add(User user);

    void createAdminIfNotExist();

}
