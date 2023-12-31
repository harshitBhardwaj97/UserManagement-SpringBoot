package com.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	User findByEmailId(String emailId);

	User findByName(String name);

}
