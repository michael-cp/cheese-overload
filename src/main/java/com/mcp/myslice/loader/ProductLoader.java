package com.mcp.myslice.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mcp.myslice.model.Product;
import com.mcp.myslice.repository.DataTypeRepository;
import com.mcp.myslice.repository.ProductRepository;
import com.mcp.myslice.utils.ApplicationConstants;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;
	private DataTypeRepository dataTypeRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Autowired
	public void setDataTypeRepository(DataTypeRepository dataTypeRepository) {
		this.dataTypeRepository = dataTypeRepository;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		
		if(productRepository.findAll().isEmpty()){
			
			Long pizzaProductId = dataTypeRepository.findByTypeName("Pizza").getDataTypeId();
			Long sidesProductId = dataTypeRepository.findByTypeName("Sides").getDataTypeId();
			Long drinksProductId = dataTypeRepository.findByTypeName("Drinks").getDataTypeId();
			
			
			productRepository.save(new Product("All-Meat Overload"
					, "Has seven kinds of meats and cheeses - Italian sausage, "
						+ "ground beef, pepperoni, salami strips, bacon, "
						+ "parmesan cheese and mozzarella cheese."
					, "all_meat_cheese_ol_1.png"
					, ApplicationConstants.IMAGE_LOCATION
					, pizzaProductId));
			
			
			productRepository.save(new Product("Bacon Overload"
					, "Limited-time offer. Topped with BACON, ham, mushrooms, "
						+ "mozzarella and cream cheese. "
					, "bacon_overload_shot.jpg"
					, ApplicationConstants.IMAGE_LOCATION
					, pizzaProductId));
			
			productRepository.save(new Product("Ultimate Overload"
					, "Has three times more toppings of 100% mozzarella cheese, "
						+ "premium meats and fresh vegetables."
					, "greenwich_special_ol_1.png"
					, ApplicationConstants.IMAGE_LOCATION
					, pizzaProductId));
			
			productRepository.save(new Product("Hawaiian Overload"
					, "2x more Hawaiian toppings! Premium Ham, Glazed Pineapple, "
						+ "Smoked Bacon, and 100% Mozzarella & Cheddar Cheese."
					, "ultimate_hawaiian_ol_3.png"
					, ApplicationConstants.IMAGE_LOCATION
					, pizzaProductId));
			
			productRepository.save(new Product("Wackys wings"
					, "Pizza's perfect partner. Available in 4pcs, 6pcs, and "
						+ "12pcs ala carte. (wingette and drumette)"
					, "wacky_wings.png"
					, ApplicationConstants.IMAGE_LOCATION
					, sidesProductId));
			
			productRepository.save(new Product("Cheesy Bread Sticks with Dip"
					, "Cheesy Bread Sticks with Dip"
					, "cheesy_bread_sticks_w__dip_2.jpg"
					, ApplicationConstants.IMAGE_LOCATION
					, sidesProductId));
			
			productRepository.save(new Product("LEMON & PAEROA 1.5L"
					, "Good lemonish stuff"
					, "6009_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId));
			
			productRepository.save(new Product("FANTA 1.5L"
					, "Create more play in the world and have more fun"
					, "6007_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId));
			
		} 
		
	}

	
	
}
