package com.mcp.myslice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mcp.myslice.model.DataType;
import com.mcp.myslice.model.UserAccount;
import com.mcp.myslice.repository.DataTypeRepository;
import com.mcp.myslice.repository.UserAccountRepository;

/**
 * 
 * @author michael.cp
 * My demo project for integrating back-end systems of a pizzeria business.
 *
 */

@SpringBootApplication
public class MySliceApplication {


	private static final Logger log = LoggerFactory.getLogger(MySliceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MySliceApplication.class, args);
	}


//
//	@Bean
//	public CommandLineRunner loadData(DataTypeRepository repository) {
//		return args -> {   
//			
//			if(repository.findAll().isEmpty()){
//				repository.save(new DataType("Pizza", "Product"));
//				repository.save(new DataType("Drinks", "Product"));
//				repository.save(new DataType("Sides", "Product"));
//
//				repository.save(new DataType("In-Store", "Order Request"));
//				repository.save(new DataType("Phone", "Order Request"));
//				repository.save(new DataType("Online", "Order Request"));
//			}
//
//		};
//	}
}
