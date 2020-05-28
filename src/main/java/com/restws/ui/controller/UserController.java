package com.restws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restws.com.restws.ui.model.User;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
		return "Get User is called with page = " + page + " limit = " + limit + " sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User returnUser = new User("first", "last", "email", "25");

		return new ResponseEntity<User>(returnUser,HttpStatus.OK);
	}

	@PostMapping
	public String createUser() {

		return "Create User is called";
	}

	@PutMapping
	public String updateUser() {

		return "Update User is called";
	}

	@DeleteMapping
	public String deleteUser() {

		return "Delete User is called";
	}
}
