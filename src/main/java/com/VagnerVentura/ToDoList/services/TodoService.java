package com.VagnerVentura.ToDoList.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VagnerVentura.ToDoList.entity.Todo;
import com.VagnerVentura.ToDoList.repositories.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository repository) {
		todoRepository = repository;
	}

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo findById(Long id) {
		return todoRepository.findById(id).orElseThrow();
	}
	
	public Todo create(Todo todo) {
		return todoRepository.save(todo);
	}

	public Todo update(Todo todo) {
		
		Todo entity = todoRepository.getReferenceById(todo.getId());
		
		entity.setId(todo.getId());
		entity.setNome(todo.getNome());
		entity.setDescrição(todo.getDescrição());
		entity.setPrioridade(todo.getPrioridade());
		entity.setRealizado(todo.isRealizado());
		
		var newTodo = todoRepository.save(entity);
		
		return newTodo ;
	}
	
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

}
