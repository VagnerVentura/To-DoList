package com.VagnerVentura.ToDoList.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.VagnerVentura.ToDoList.dto.UserDTO;
import com.VagnerVentura.ToDoList.entity.User;
import com.VagnerVentura.ToDoList.mapper.DozzerMapper;
import com.VagnerVentura.ToDoList.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository repository;
	
	public UserService (UserRepository repository) {
		this.repository = repository;
	}
	
	public List<UserDTO> findAll() {
		var entity = repository.findAll();
		return entity.stream().map(DozzerMapper::toDTO).collect(Collectors.toList());
	}

	public UserDTO create(UserDTO dto) {
		var newUser = repository.save(DozzerMapper.toEntity(dto));
		return DozzerMapper.toDTO(newUser);
	}

	public UserDTO findById(UserDTO dto) {
		User userdto = repository.findById(dto.getId()).orElseThrow();
		return DozzerMapper.toDTO(userdto);
	}
	
}
