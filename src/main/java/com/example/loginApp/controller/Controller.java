package com.example.loginApp.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginApp.Entity.Book;
import com.example.loginApp.Service.AccountService;
import com.example.loginApp.utility.Profile;
import com.example.loginApp.utility.ResponseMessage;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class Controller {
	
	@Autowired
	private AccountService as ;
	
	@GetMapping("/users")
	public List<Profile> getUsers() {
		return new LinkedList<>();
	}
	
	
	@GetMapping("/profile")
	public Profile profile(@RequestHeader("Authorization") String bearer_token) {
		String token = bearer_token.replaceFirst("Bearer ", "");
		String id = as.decodeJWT(token);
		return as.getUserById(id);
	}
	
	@GetMapping("/info")
	public void info(@RequestHeader("Authorization")String token) {
		System.out.println(token.replaceFirst("Bearer ",""));
		as.decodeJWT(token.replaceFirst("Bearer ",""));
	}
	
}
