package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.DataType;
import com.mcp.myslice.repository.DataTypeRepository;

@RestController
@RequestMapping("api/v1/")
public class DataTypeController {

	
	@Autowired
	private DataTypeRepository dataTypeRepository;
	
	@RequestMapping(value = "datatypes" , method = RequestMethod.GET)
	public List<DataType> list(){
		return dataTypeRepository.findAll();
	}

	@RequestMapping(value = "datatypes" , method = RequestMethod.POST)
	public DataType create(@RequestBody DataType dataType){
		return dataTypeRepository.saveAndFlush(dataType);
	}
	
	@RequestMapping(value = "datatypes/{id}" , method = RequestMethod.GET)
	public DataType get(@PathVariable Long id){
		return dataTypeRepository.findOne(id);
	}

	@RequestMapping(value = "datatypes/{id}" , method = RequestMethod.PUT)
	public DataType update(@PathVariable Long id, @RequestBody DataType dataType){
		DataType existingDataType = dataTypeRepository.findOne(id);
		BeanUtils.copyProperties(dataType, existingDataType);
		return dataTypeRepository.saveAndFlush(existingDataType);
	}
	
	@RequestMapping(value = "datatypes/{id}" , method = RequestMethod.DELETE)
	public DataType delete(@PathVariable Long id, @RequestBody DataType dataType){
		DataType existingDataType = dataTypeRepository.findOne(id);
		dataTypeRepository.delete(existingDataType);
		
		return existingDataType;
	}
	
	
}
