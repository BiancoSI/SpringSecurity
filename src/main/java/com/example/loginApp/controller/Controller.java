package com.example.loginApp.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginApp.Entity.Book;
import com.example.loginApp.utility.ResponseMessage;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class Controller {
	private Map<Long, Book> books = new HashMap<>();
	
	@GetMapping("stocazzo")
	public ResponseEntity st() {
		return new ResponseEntity<>(new ResponseMessage("OK SONO EBREO"), HttpStatus.OK);
	}
	
	/*
	@PostMapping("book/add")
	public ResponseEntity stocazzo(@RequestBody @Valid Book b) {
		
	}
	*/
	
	@PutMapping("stocazzo/{id}")
	public ResponseEntity stocazzo(@PathVariable int id) {
		System.out.println("Arrivata "+id);
		return new ResponseEntity<>(new ResponseMessage("OK SONO EBREO"), HttpStatus.OK);
	}
	@GetMapping("/book")
	public List<Book> books() {
		return new LinkedList<>(books.values());
	}
}
