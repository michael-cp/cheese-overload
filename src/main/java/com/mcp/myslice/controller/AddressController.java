package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.Address;
import com.mcp.myslice.repository.AddressRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@RestController
@RequestMapping("api/v1/")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@RequestMapping(value = "addresses" , method = RequestMethod.GET)
	public List<Address> list(){
		return addressRepository.findAll();
	}

	@RequestMapping(value = "addresses" , method = RequestMethod.POST)
	public Address create(@RequestBody Address address){
		return addressRepository.saveAndFlush(address);
	}
	
	@RequestMapping(value = "addresses/{id}" , method = RequestMethod.GET)
	public Address get(@PathVariable Long id){
		return addressRepository.findOne(id);
	}

	@RequestMapping(value = "addresses/{id}" , method = RequestMethod.PUT)
	public Address update(@PathVariable Long id, @RequestBody Address address){
		Address existingAddress = addressRepository.findOne(id);
		BeanUtils.copyProperties(address, existingAddress);
		return addressRepository.saveAndFlush(existingAddress);
	}
	
	@RequestMapping(value = "addresses/{id}" , method = RequestMethod.DELETE)
	public Address delete(@PathVariable Long id, @RequestBody Address address){
		Address existingAddress = addressRepository.findOne(id);
		
		/**
			Disabled the actual deletion of data.
		**/
		//addressRepository.delete(existingAddress);
		
		
		/*
			Instead of deleting the actual data, flag the Active attribute to No/"N"..
		*/
		existingAddress.setActive(ApplicationConstants.ACTIVE_NO);
		BeanUtils.copyProperties(address, existingAddress);
		addressRepository.saveAndFlush(existingAddress);
		
		return existingAddress;
	}
	
}
