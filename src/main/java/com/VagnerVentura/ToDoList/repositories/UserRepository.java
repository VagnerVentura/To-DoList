package com.VagnerVentura.ToDoList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VagnerVentura.ToDoList.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
