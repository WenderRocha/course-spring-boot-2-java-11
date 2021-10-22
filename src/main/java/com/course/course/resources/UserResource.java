package com.course.course.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		User u1 = User.builder().id(1L).name("Wender").email("wender_dev@hotmail.com").phone("(19) 999810604")
				.password("12345678").build();

		User u2 = User.builder().id(2L).name("João").email("joaov@hotmail.com").phone("(19) 999610309")
				.password("12345678").build();

		return ResponseEntity.ok().body(Arrays.asList(u1, u2));

	}
}
