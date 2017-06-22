package com.mcp.myslice.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mcp.myslice.model.DataType;
import com.mcp.myslice.repository.DataTypeRepository;

@Component
public class DataTypeLoader implements ApplicationListener<ContextRefreshedEvent> {

	private DataTypeRepository dataTypeRepository;
	
	@Autowired
	public void setDataTypeRepository(DataTypeRepository dataTypeRepository) {
		this.dataTypeRepository = dataTypeRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		
		if(dataTypeRepository.findAll().isEmpty()){
			
			dataTypeRepository.save(new DataType("Pizza", "Product"));
			dataTypeRepository.save(new DataType("Drinks", "Product"));
			dataTypeRepository.save(new DataType("Sides", "Product"));

			dataTypeRepository.save(new DataType("In-Store", "Order Request"));
			dataTypeRepository.save(new DataType("Phone", "Order Request"));
			dataTypeRepository.save(new DataType("Online", "Order Request"));
		}
		
	}

	
	
}
