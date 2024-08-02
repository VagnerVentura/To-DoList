package com.VagnerVentura.ToDoList.mapper;

import com.VagnerVentura.ToDoList.dto.UserDTO;
import com.VagnerVentura.ToDoList.entity.User;

public class DozzerMapper {

	public static UserDTO toDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setNome(entity.getNome());
		dto.setEmail(entity.getEmail());
		dto.setMatricula(entity.getMatricula());
		return dto;
	}
		
	public static User toEntity(UserDTO dto) {
		User entity = new User();
		entity.setEmail(dto.getEmail());
		entity.setNome(dto.getNome());
		entity.setMatricula(dto.getMatricula());
		entity.setSenha(dto.getSenha());
		return entity;
	}
	
}
