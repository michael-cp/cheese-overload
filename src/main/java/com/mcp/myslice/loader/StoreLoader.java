package com.mcp.myslice.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mcp.myslice.model.Store;
import com.mcp.myslice.repository.StoreRepository;

@Component
public class StoreLoader implements ApplicationListener<ContextRefreshedEvent>{

	private StoreRepository storeRepository;

	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub

		if(storeRepository.findAll().isEmpty()){

			storeRepository.save(
					new Store("Smith & Caugheys 261"
							, "Queen Street"
							, "Auckland"
							, "Auckland"
							, "Auckland"
							, "1010"
							, "Mon to Sun: 9:00am to 10:00pm"
							, "Dine-in, Take-away, Delivery"
							, -36.850454
							, 174.764557));

		}

	}



}
