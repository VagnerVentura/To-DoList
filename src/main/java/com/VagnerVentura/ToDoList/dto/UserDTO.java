package com.VagnerVentura.ToDoList.dto;

import java.util.List;

import com.VagnerVentura.ToDoList.entity.Todo;

public class UserDTO {

	private Long id;
	private String nome;
	private Integer matricula;
	private String email;
	private String senha;
	private List<Todo> todos;
	
	public UserDTO(String nome, Integer matricula, String email, Long id) {
		this.id= id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todo) {
		this.todos =  todo;
	}

	public UserDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public Long getId() {
		return id;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
		
}
