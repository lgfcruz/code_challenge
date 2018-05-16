package com.vague.code_challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vague.code_challenge.model.entity.User;
import com.vague.code_challenge.model.vo.CreateUserVO;
import com.vague.code_challenge.repository.UserRepository;
import com.vague.code_challenge.service.MessageLocaleService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    MessageLocaleService messageLocaleService;
	
	@GetMapping
	public ResponseEntity<?> listAllUsers(@RequestParam(value = "role", required=false) String role) {
		if (role != null) {
			return new ResponseEntity<>(userRepository.findByRole(role), HttpStatus.OK);
		}
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		
    }
	
	@PostMapping
	public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserVO vo) {
		return new ResponseEntity<>(userRepository.save(new User(vo.getName(), vo.getRole())), HttpStatus.CREATED);
	}

}
