package com.mcp.myslice.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.myslice.model.Product;
import com.mcp.myslice.repository.ProductRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "products" , method = RequestMethod.GET)
	public List<Product> list(){
//		return productRepository.findAll();
		return productRepository.findByActive(ApplicationConstants.ACTIVE_YES);
	}

	@RequestMapping(value = "products/type/{id}" , method = RequestMethod.GET)
	public List<Product> getByTypelist(@PathVariable Long id){
//		return productRepository.findAll();
		return productRepository.findByProductTypeId(id);
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
	
	@DeleteMapping("product")
	public ResponseEntity<Void> deleteProduct(@RequestParam("id") String id) {
		System.out.println("delete!!");
		productRepository.delete(Long.parseLong(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@RequestMapping(value = "products/delete/{id}" , method = RequestMethod.GET)
	public String deleteProduct(@PathVariable Long id){
		System.out.println("delete!! 2222");
//		Product existingProduct = productRepository.findOne(id);
		
		return "delete!";
	}
	
//	@RequestMapping(value = "products/del/{id}" , method = RequestMethod.PUT)
//	@DeleteMapping("products")
//	public Product delete(@RequestParam("id") Long id){
//		System.out.println("<<< DELETE PRODUCT");
//		Product existingProduct = productRepository.findOne(id);
//		
//		/**
//			Disabled the actual deletion of data.
//		**/
//		//productRepository.delete(existingProduct);
//		
//		
//		/*
//			Instead of deleting the actual data, flag the Active attribute to No/"N"..
//		*/
//		existingProduct.setActive(ApplicationConstants.ACTIVE_NO);
//		productRepository.saveAndFlush(existingProduct);
//		
//		return existingProduct;
//	}
	
}
