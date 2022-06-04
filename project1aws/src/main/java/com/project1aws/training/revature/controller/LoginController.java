package com.project1aws.training.revature.controller;

import com.project1aws.training.revature.model.LoginTemplate;
import com.project1aws.training.revature.model.User;
import com.project1aws.training.revature.model.LoginTemplate;
import com.project1aws.training.revature.model.User;
import com.project1aws.training.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//	@Autowired
//	private UserService userService;
//
//
//	@PostMapping("/login")
//	public ResponseEntity<User> login(@RequestBody LoginTemplate loginTemplate) {
//
//		return ResponseEntity.ok(userService.login(loginTemplate.getUsername(), loginTemplate.getPassword()));
//	}
//
//	@PostMapping("/logout")
//	public ResponseEntity<Void> logout() {
//		userService.logout();
//
//		return ResponseEntity.accepted().build();
//	}
}
