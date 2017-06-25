package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.SizeNPrice;
import com.mcp.myslice.repository.SizeNPriceRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@RestController
@RequestMapping("api/v1/")
public class SizeNPrizeController {

	@Autowired
	private SizeNPriceRepository sizeNPriceRepository;
	
	@RequestMapping(value = "sizenprices" , method = RequestMethod.GET)
	public List<SizeNPrice> list(){
		return sizeNPriceRepository.findAll();
	}
	
	@RequestMapping(value="sizenprices/{id}" , method = RequestMethod.GET)
	public List<SizeNPrice> getByProductList(@PathVariable String id){ 
		return sizeNPriceRepository.findByProductId(Long.parseLong(id));
	}

	@RequestMapping(value = "sizenprices" , method = RequestMethod.POST)
	public SizeNPrice create(@RequestBody SizeNPrice sizeNPrice){
		return sizeNPriceRepository.saveAndFlush(sizeNPrice);
	}
	
	@RequestMapping(value = "sizenprice/{id}" , method = RequestMethod.GET)
	public SizeNPrice get(@PathVariable Long id){
		return sizeNPriceRepository.findOne(id);
	}

	@RequestMapping(value = "sizenprices/{id}" , method = RequestMethod.PUT)
	public SizeNPrice update(@PathVariable Long id, @RequestBody SizeNPrice sizeNPrice){
		SizeNPrice existingSizeNPrice = sizeNPriceRepository.findOne(id);
		BeanUtils.copyProperties(sizeNPrice, existingSizeNPrice);
		return sizeNPriceRepository.saveAndFlush(existingSizeNPrice);
	}
	
	@RequestMapping(value = "sizenprices/{id}" , method = RequestMethod.DELETE)
	public SizeNPrice delete(@PathVariable Long id, @RequestBody SizeNPrice sizeNPrice){
		SizeNPrice existingSizeNPrice = sizeNPriceRepository.findOne(id);
		
		/**
			Disabled the actual deletion of data.
		**/
		//sizeNPriceRepository.delete(existingSizeNPrice);
		
		
		/*
			Instead of deleting the actual data, flag the Active attribute to No/"N"..
		*/
		existingSizeNPrice.setActive(ApplicationConstants.ACTIVE_NO);
		BeanUtils.copyProperties(sizeNPrice, existingSizeNPrice);
		sizeNPriceRepository.saveAndFlush(existingSizeNPrice);
		
		return existingSizeNPrice;
	}
	
}
