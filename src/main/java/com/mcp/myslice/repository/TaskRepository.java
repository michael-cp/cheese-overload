package com.mcp.myslice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.myslice.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
