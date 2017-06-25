package com.mcp.myslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
