package com.VagnerVentura.ToDoList.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.VagnerVentura.ToDoList.dto.UserDTO;
import com.VagnerVentura.ToDoList.entity.User;
import com.VagnerVentura.ToDoList.mapper.UserMapper;
import com.VagnerVentura.ToDoList.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository repository;
	
	public UserService (UserRepository repository) {
		this.repository = repository;
	}
	
	public List<UserDTO> findAll() {
		var entity = repository.findAll();
		return entity.stream().map(UserMapper::toDTO).collect(Collectors.toList());
	}

	public UserDTO create(UserDTO dto) {
		var newUser = repository.save(UserMapper.toEntity(dto));
		return UserMapper.toDTO(newUser);
	}

	public UserDTO findById(UserDTO dto) {
		User userdto = repository.findById(dto.getId()).orElseThrow();
		return UserMapper.toDTO(userdto);
	}

	public UserDTO update(UserDTO dto) {
		
		User entity = repository.findById(dto.getId()).orElseThrow();
		
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setMatricula(dto.getMatricula());
		entity.setSenha(dto.getSenha());
				
		var newUser = repository.save(entity);
		return UserMapper.toDTO(newUser);	
	}

	public void delete(Long id) {
		User entity = repository.findById(id).orElseThrow();
		repository.delete(entity);
	}
	
}
