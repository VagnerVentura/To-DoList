package com.VagnerVentura.ToDoList.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VagnerVentura.ToDoList.entity.Todo;
import com.VagnerVentura.ToDoList.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService service) {
		todoService = service;
	}
	
	@GetMapping
	public List<Todo> findAll(){
		return todoService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Todo findById(@PathVariable(value= "id") Long id) {
		  return todoService.findById(id);
	}
	
	@PostMapping(value = "/{id}")
	public Todo create (@RequestBody Todo todo) {
		return todoService.create(todo);
	}
	
}
