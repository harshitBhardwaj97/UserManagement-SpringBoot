package com.usermanagement.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.usermanagement.dto.UserDTO;
import com.usermanagement.exception.UserNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO getUser(Long userId) {
		User foundUser = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found !"));
		UserDTO foundUserDto = userToDto(foundUser);
		return foundUserDto;
	}

	@Override
	public UserDTO getUserByEmailId(String emailId) {
		User userFoundByEmailId = userRepository.findByEmailId(emailId);
		if (Objects.isNull(userFoundByEmailId)) {
			throw new UserNotFoundException("User with email id " + emailId + " not found !");
		}
		UserDTO userFoundByEmailIdDto = userToDto(userFoundByEmailId);
		return userFoundByEmailIdDto;

	}

	@Override
	public UserDTO getUserByUserName(String userName) {
		User userFoundByUserName = userRepository.findByUserName(userName);
		if (Objects.isNull(userFoundByUserName)) {
			throw new UserNotFoundException("User with user name " + userName + " not found !");
		}
		UserDTO userFoundByUserNameDto = userToDto(userFoundByUserName);
		return userFoundByUserNameDto;
	}

	@Override
	public UserDTO getUserByName(String name) {
		User userFoundByName = userRepository.findByName(name);
		if (Objects.isNull(userFoundByName)) {
			throw new UserNotFoundException("User with name " + name + " not found !");
		}
		UserDTO userFoundByNameDto = userToDto(userFoundByName);
		return userFoundByNameDto;
	}

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User savedUser = User.builder().name(userDto.getName()).emailId(userDto.getEmailId())
				.userName(userDto.getUserName()).build();
		userRepository.save(savedUser);
		UserDTO savedUserDto = userToDto(savedUser);
		return savedUserDto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepository.findAll();
		List<UserDTO> userDtoList = userList.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		return userDtoList;
	}

//	@Override
//	public UserDTO updateUser(UserDTO userDto) {
//
//	}

	@Override
	public Boolean deleteUser(Long userId) {
		User deletedUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
				"User with id " + userId + " cannot be deleted becasue its not found !"));
		;
		userRepository.delete(deletedUser);
		return true;
	}

	private UserDTO userToDto(User user) {
		UserDTO userDto = UserDTO.builder().name(user.getName()).emailId(user.getEmailId()).userName(user.getName())
				.build();
		return userDto;
	}

}
