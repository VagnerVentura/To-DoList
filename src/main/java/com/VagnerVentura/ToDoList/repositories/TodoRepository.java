package com.VagnerVentura.ToDoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VagnerVentura.ToDoList.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
