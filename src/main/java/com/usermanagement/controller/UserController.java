package com.usermanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.dto.UserDTO;
import com.usermanagement.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users/id/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
		UserDTO userDto = userService.getUser(userId);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);

	}

	@GetMapping("/users/username/{userName}")
	public ResponseEntity<UserDTO> getUserByUserName(@PathVariable String userName) {
		UserDTO userDto = userService.getUserByUserName(userName);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);

	}

	@GetMapping("/users/email/{emailId}")
	public ResponseEntity<UserDTO> getUserByEmailId(@PathVariable String emailId) {
		UserDTO userDto = userService.getUserByEmailId(emailId);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);

	}

	@GetMapping("/users/name/{name}")
	public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
		UserDTO userDto = userService.getUserByName(name);
		return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);

	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userDtoList = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userDtoList, HttpStatus.OK);

	}

	@PostMapping("/users/createUser")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
		UserDTO createdUserDto = userService.createUser(userDto);
		return new ResponseEntity<UserDTO>(createdUserDto, HttpStatus.CREATED);
	}

	@DeleteMapping("/users/deleteUser/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
		Boolean result = userService.deleteUser(userId);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}

}
