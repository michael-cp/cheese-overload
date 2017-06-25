package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.Store;
import com.mcp.myslice.repository.StoreRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@RestController
@RequestMapping("api/v1/")
public class StoreController {

	@Autowired
	private StoreRepository storeRepository;
	
	@RequestMapping(value = "stores" , method = RequestMethod.GET)
	public List<Store> list(){
		return storeRepository.findAll();
	}

	@RequestMapping(value = "stores" , method = RequestMethod.POST)
	public Store create(@RequestBody Store store){
		return storeRepository.saveAndFlush(store);
	}
	
	@RequestMapping(value = "stores/{id}" , method = RequestMethod.GET)
	public Store get(@PathVariable Long id){
		return storeRepository.findOne(id);
	}

	@RequestMapping(value = "stores/{id}" , method = RequestMethod.PUT)
	public Store update(@PathVariable Long id, @RequestBody Store store){
		Store existingStore = storeRepository.findOne(id);
		BeanUtils.copyProperties(store, existingStore);
		return storeRepository.saveAndFlush(existingStore);
	}
	
	@RequestMapping(value = "stores/{id}" , method = RequestMethod.DELETE)
	public Store delete(@PathVariable Long id, @RequestBody Store store){
		Store existingStore = storeRepository.findOne(id);
		
		/**
			Disabled the actual deletion of data.
		**/
		//storeRepository.delete(existingStore);
		
		
		/*
			Instead of deleting the actual data, flag the Active attribute to No/"N"..
		*/
		existingStore.setActive(ApplicationConstants.ACTIVE_NO);
		BeanUtils.copyProperties(store, existingStore);
		storeRepository.saveAndFlush(existingStore);
		
		return existingStore;
	}
	
}
