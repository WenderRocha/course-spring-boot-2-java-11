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
		User u1 = new User(1L, "Maria", "maria@gmail.com", "(19) 999810604", "123456");
		User u2 = new User(2L, "Pedro", "pedro@gmail.com", "(19) 999887372", "1234232356");

		return ResponseEntity.ok().body(Arrays.asList(u1, u2));

	}
}
