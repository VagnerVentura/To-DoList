package com.VagnerVentura.ToDoList.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.VagnerVentura.ToDoList.dto.UserDTO;
import com.VagnerVentura.ToDoList.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service; 
	}
	
	@GetMapping
	public  List<UserDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public UserDTO findById(@PathVariable Long id, UserDTO dto) {
		dto.setId(id);
		return service.findById(dto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto, UriComponentsBuilder uriBuilder){
		var user = service.create(dto);		
		var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getNome()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	
	
	
	
	
	
}
