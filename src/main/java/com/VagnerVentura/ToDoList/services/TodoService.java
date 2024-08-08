package com.VagnerVentura.ToDoList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VagnerVentura.ToDoList.entity.Todo;
import com.VagnerVentura.ToDoList.entity.User;
import com.VagnerVentura.ToDoList.repositories.TodoRepository;
import com.VagnerVentura.ToDoList.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo findById(Long id) {
		return todoRepository.findById(id).orElseThrow();
	}
	
	@Transactional
	public Todo create(Todo todo) {
		var entity = userRepository.findById(todo.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		todo.setUser(entity);		
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
