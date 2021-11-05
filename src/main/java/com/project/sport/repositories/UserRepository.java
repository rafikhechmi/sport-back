package com.project.sport.repositories;

import com.project.sport.models.User;
import com.project.sport.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmailAndPassword(String email, String password);

	User findUserByEmail(String email);

	@Query(value = "select u from User u left join u.roles r where u.email = (?1) and r.name = (?2)")
	List<User> findAllByEmailAndRoleName(String email, RoleEnum roleName);
}