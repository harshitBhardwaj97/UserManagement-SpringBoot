package com.usermanagement.service;

import java.util.List;

import com.usermanagement.dto.UserDTO;

public interface UserService {

	UserDTO getUser(Long userId);

	UserDTO getUserByEmailId(String emailId);

	UserDTO getUserByUserName(String userName);

	UserDTO getUserByName(String name);

	UserDTO createUser(UserDTO userDto);

	List<UserDTO> getAllUsers();

//	UserDTO updateUser(UserDTO userDto);

	Boolean deleteUser(Long userId);

}
