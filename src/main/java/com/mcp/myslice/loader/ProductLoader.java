package com.mcp.myslice.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mcp.myslice.model.Product;
import com.mcp.myslice.model.SizeNPrice;
import com.mcp.myslice.repository.DataTypeRepository;
import com.mcp.myslice.repository.ProductRepository;
import com.mcp.myslice.repository.SizeNPriceRepository;
import com.mcp.myslice.utils.ApplicationConstants;

/**
 * 
 * Generate the initial data of products and size with price.  
 *
 */

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

	private ProductRepository productRepository;
	private DataTypeRepository dataTypeRepository;
	private SizeNPriceRepository sizeNPriceRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Autowired
	public void setDataTypeRepository(DataTypeRepository dataTypeRepository) {
		this.dataTypeRepository = dataTypeRepository;
	}

	@Autowired
	public void setSizeNPriceRepository(SizeNPriceRepository sizeNPriceRepository) {
		this.sizeNPriceRepository = sizeNPriceRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		
		if(productRepository.findAll().isEmpty()){
			
			/** ------------------------- Pizzas Section -------------------------- **/
			
			Long pizzaProductId = dataTypeRepository.findByTypeName("Pizza").getDataTypeId();
			Long sidesProductId = dataTypeRepository.findByTypeName("Sides").getDataTypeId();
			Long drinksProductId = dataTypeRepository.findByTypeName("Drinks").getDataTypeId();
			
			
			Product meatOverload = new Product("All-Meat Overload"
					, "The ultimate combination of tasty pepperoni, italian sausage, ham, "
							+ "freshly slices mushrooms, onions, green peppers and black olives"
						, "MeatOverload.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId);
			
			productRepository.save(meatOverload);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "8", meatOverload.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "9.4", meatOverload.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "10.5", meatOverload.getProductId()));

			Product texasHeat = new Product("Texas Heat"
					, "Ground beef, crispy bacon bits, onions, green peppers "
							+ "and spicy jalapeño peppers "
						, "TexasHeat.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId);
 
			productRepository.save(texasHeat);

			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "6.5", texasHeat.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "7.4", texasHeat.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "9.5", texasHeat.getProductId()));

			Product baconMelt = new Product("Cheesy Bacon Melt"
					, "Gooey melty goodness made out of creamy potato mousse, generous "
							+ "serving of cheese and topped with crispy bacon bits for "
							+ "a perfect cheeselicious treat."
						, "CheesyBaconMelt.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId);
			
			productRepository.save(baconMelt);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "8", baconMelt.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "9.4", baconMelt.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "10.5", baconMelt.getProductId()));
			
			Product chickenBbq = new Product("Chicken BBQ"
					, "Tender grilled chicken, bacon bits and onions combined "
							+ "with a sweet and tangy BBQ sauce"
						, "ChickenBBQ.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId); 
			
			productRepository.save(chickenBbq);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "6.5", chickenBbq.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "7.4", chickenBbq.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "9.5", chickenBbq.getProductId()));
			
			Product simplyCheese = new Product("Simply Cheese"
					, "Mild and delicate mozarella cheese yet full bodied in flavor"
						, "SimplyCheese.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId); 
			
			productRepository.save(simplyCheese);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "6.5", simplyCheese.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "7.4", simplyCheese.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "9.5", simplyCheese.getProductId()));
			
			Product gardenSpecial = new Product("Garden Special"
					, "Garden-fresh mushrooms, juicy tomatoes, crunchy green "
							+ "peppers, onions and black olives"
						, "GardenSpecial.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId); 
			
			productRepository.save(gardenSpecial);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "6.5", gardenSpecial.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "7.4", gardenSpecial.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "9.5", gardenSpecial.getProductId()));
			
			Product pepperoni = new Product("Pepperoni"
					, "Generous servings of pepperoni slices smothered in extra "
							+ "melt-in-your-mouth cheese"
						, "Pepperoni.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId); 
			
			productRepository.save(pepperoni);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "8", pepperoni.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "9.4", pepperoni.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "10.5", pepperoni.getProductId()));
			
			Product hawaiian = new Product("The Hawaiian"
					, "Loaded with ham, sweet and juicy pineapple combined with an extra "
							+ "helping of mozarella cheese"
						, "Hawaiian.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, pizzaProductId); 
			
			productRepository.save(hawaiian);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SMALL_PIZZA, "8", hawaiian.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.MEDIUM_PIZZA, "9.4", hawaiian.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.LARGE_PIZZA, "10.5", hawaiian.getProductId()));
			
			
			/** ------------------------- Sides Section -------------------------- **/
			
			Product flavoredWings = new Product("Flavored Wings"
					, "Savor the sizzle of plump and juicy flavored wings in the "
							+ "following flavors: Soy Honey, Hickory BBQ, Buffalo"
						, "FlavoredWings.jpg"
						, ApplicationConstants.IMAGE_LOCATION
						, sidesProductId);
			
			productRepository.save(flavoredWings);
			
			sizeNPriceRepository.save(new SizeNPrice("4pcs", "4", flavoredWings.getProductId()));
			sizeNPriceRepository.save(new SizeNPrice("6pcs", "5.5", flavoredWings.getProductId()));
			
			
			Product potatoWedges = new Product("Seasoned Potato Wedges"
					, "Potato wedges baked into golden brown, crisp on the "
							+ "outside served with pizza sauce"
					, "PotatoWedges.jpg"
					, ApplicationConstants.IMAGE_LOCATION
					, sidesProductId);
			
			productRepository.save(potatoWedges);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SINGLE_SIZE, "3", potatoWedges.getProductId()));
			
			Product cheeseSticks = new Product("Cheesesticks"
					, "Our fresh dough covered with special garlic sauce "
							+ "and topped with mozarella cheese"
					, "Cheesesticks.jpg"
					, ApplicationConstants.IMAGE_LOCATION
					, sidesProductId);
			
			productRepository.save(cheeseSticks);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.SINGLE_SIZE, "3", cheeseSticks.getProductId()));
			

			Product caramelStromboli = new Product("Sweet Caramel Stromboli"
					, "Our fresh dough covered with special garlic sauce "
							+ "and topped with mozarella cheese"
					, "SweetCaramel.jpg"
					, ApplicationConstants.IMAGE_LOCATION
					, sidesProductId);
			 
			productRepository.save(caramelStromboli);
			
			sizeNPriceRepository.save(new SizeNPrice("7pcs", "3.7", caramelStromboli.getProductId()));
			
			
			
			/** ------------------------- Drinks Section -------------------------- **/
			
			Product lemonPaeroa = new Product("LEMON & PAEROA 1.5L"
					, "Good lemonish stuff"
					, "6009_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
			
			productRepository.save(lemonPaeroa);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "3.2", lemonPaeroa.getProductId()));
			
			Product fanta = new Product("FANTA 1.5L"
					, "Create more play in the world and have more fun"
					, "6007_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
					
			productRepository.save(fanta);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "3.2", fanta.getProductId()));
			
			Product cocaCola = new Product("COCA COLA 1.5L"
					, "Enjoy the uplifting taste of the original flavor "
					, "6002_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
			
			productRepository.save(cocaCola);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "3.2", cocaCola.getProductId()));
			
			Product cokeZero = new Product("COKE ZERO 1.5L "
					, "Great coke taste, zero sugar "
					, "6003_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
			
			productRepository.save(cokeZero);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "3.2", cokeZero.getProductId()));
			
			Product kiwiBlue = new Product("KIWI BLUE STILL WATER"
					, "Kiwi Blue is sourced from specially selected "
						+ "New Zealand springs, to keeps you hydrated "
					, "6013_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
			
			productRepository.save(kiwiBlue);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "3.2", kiwiBlue.getProductId()));
			
			Product stillPump = new Product("STILL PUMP 750ML"
					, "Pump fuels a greater thirst for life. "
					, "6069_Product_Large_Image_en-AU.png"
					, ApplicationConstants.IMAGE_LOCATION
					, drinksProductId);
			
			productRepository.save(stillPump);
			
			sizeNPriceRepository.save(new SizeNPrice(ApplicationConstants.DEFAULT_SIZE, "2.8", stillPump.getProductId()));
			
			
		} 
		
	}

	
	
}
