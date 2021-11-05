package com.project.sport.repositories;

import com.project.sport.models.Role;
import com.project.sport.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleEnum name);
}