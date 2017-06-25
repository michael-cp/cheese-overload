package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.ToDo;
import com.mcp.myslice.repository.ToDoRepository;

@RestController
@RequestMapping("api/v1/")
public class ToDoController {
	@Autowired
	private ToDoRepository toDoRepository;
	
	@RequestMapping(value = "todos" , method = RequestMethod.GET)
	public List<ToDo> list(){
		return toDoRepository.findAll();
	}

	@RequestMapping(value = "todos" , method = RequestMethod.POST)
	public ToDo create(@RequestBody ToDo toDo){
		System.out.println("Create TODO??? ");
		return toDoRepository.saveAndFlush(toDo);
	}
	
	@RequestMapping(value = "todos/{id}" , method = RequestMethod.GET)
	public ToDo get(@PathVariable Long id){
		return toDoRepository.findOne(id);
	}

	@RequestMapping(value = "todos/{id}" , method = RequestMethod.PUT)
	public ToDo update(@PathVariable Long id, @RequestBody ToDo toDo){
		ToDo existingToDo = toDoRepository.findOne(id);
		BeanUtils.copyProperties(toDo, existingToDo);
		return toDoRepository.saveAndFlush(existingToDo);
	}
	
	@RequestMapping(value = "todos/{id}" , method = RequestMethod.DELETE)
	public ToDo delete(@PathVariable Long id, @RequestBody ToDo toDo){
		ToDo existingToDo = toDoRepository.findOne(id);
		toDoRepository.delete(existingToDo);
		return existingToDo;
	}	
}
