package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.Task;
import com.mcp.myslice.repository.TaskRepository;

@RestController
@RequestMapping("api/v1/")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(value = "tasks" , method = RequestMethod.GET)
	public List<Task> list(){
		return taskRepository.findAll();
	}

	@PostMapping(value = "tasks")
	public Task create(@RequestBody Task task){
		System.out.println("inside task create..." + task.getName());
		return taskRepository.saveAndFlush(task);
	}
	
	@RequestMapping(value = "tasks/{id}" , method = RequestMethod.GET)
	public Task get(@PathVariable Long id){
		return taskRepository.findOne(id);
	}

	@RequestMapping(value = "tasks/{id}" , method = RequestMethod.PUT)
	public Task update(@PathVariable Long id, @RequestBody Task task){
		Task existingTask = taskRepository.findOne(id);
		BeanUtils.copyProperties(task, existingTask);
		return taskRepository.saveAndFlush(existingTask);
	}
	
	@RequestMapping(value = "tasks/{id}" , method = RequestMethod.DELETE)
	public Task delete(@PathVariable Long id, @RequestBody Task task){
		Task existingTask = taskRepository.findOne(id);
		
		/**
			Disabled the actual deletion of data.
		**/
		taskRepository.delete(existingTask);
		
		return existingTask;
	}}
