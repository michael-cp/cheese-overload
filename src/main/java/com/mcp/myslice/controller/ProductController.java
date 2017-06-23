package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.Product;
import com.mcp.myslice.repository.ProductRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@RestController
@RequestMapping("api/v1/")
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "products" , method = RequestMethod.GET)
	public List<Product> list(){
		return productRepository.findAll();
	}

	@RequestMapping(value = "products" , method = RequestMethod.POST)
	public Product create(@RequestBody Product product){
		return productRepository.saveAndFlush(product);
	}
	
	@RequestMapping(value = "products/{id}" , method = RequestMethod.GET)
	public Product get(@PathVariable Long id){
		return productRepository.findOne(id);
	}

	@RequestMapping(value = "products/{id}" , method = RequestMethod.PUT)
	public Product update(@PathVariable Long id, @RequestBody Product product){
		Product existingProduct = productRepository.findOne(id);
		BeanUtils.copyProperties(product, existingProduct);
		return productRepository.saveAndFlush(existingProduct);
	}
	
	@RequestMapping(value = "products/{id}" , method = RequestMethod.DELETE)
	public Product delete(@PathVariable Long id, @RequestBody Product product){
		Product existingProduct = productRepository.findOne(id);
		
		/**
			Disabled the actual deletion of data.
		**/
		//productRepository.delete(existingProduct);
		
		
		/*
			Instead of deleting the actual data, flag the Active attribute to No/"N"..
		*/
		existingProduct.setActive(ApplicationConstants.ACTIVE_NO);
		BeanUtils.copyProperties(product, existingProduct);
		productRepository.saveAndFlush(existingProduct);
		
		return existingProduct;
	}
	
}
