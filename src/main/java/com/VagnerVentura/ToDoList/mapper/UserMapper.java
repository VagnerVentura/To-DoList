package com.VagnerVentura.ToDoList.mapper;

import java.util.stream.Collectors;

import com.VagnerVentura.ToDoList.dto.UserDTO;
import com.VagnerVentura.ToDoList.entity.Todo;
import com.VagnerVentura.ToDoList.entity.User;

public class UserMapper {

	public static UserDTO toDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setMatricula(entity.getMatricula());

		dto.setTodos(entity.getTodos().stream().map(todo -> {
			Todo todos = new Todo();
			todos.setId(todo.getId());
			todos.setNome(todo.getNome());
			return todos;
		}).collect(Collectors.toList()));
		return dto;
	}

	public static User toEntity(UserDTO dto) {
		User entity = new User();

		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setNome(dto.getNome());
		entity.setMatricula(dto.getMatricula());
		entity.setSenha(dto.getSenha());
		return entity;
	}

}
