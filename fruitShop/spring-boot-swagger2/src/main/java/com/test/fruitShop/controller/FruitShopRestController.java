package com.test.fruitShop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.fruitShop.model.Fruit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "FruitShopRestController", description = "REST Apis related to Fruit Entity!!!!")
@RestController
public class FruitShopRestController {

	
	List<Fruit> fruits = new ArrayList<Fruit>();
	{
		fruits.add(new Fruit("Pears", "0.75€", "3"));
		fruits.add(new Fruit("Apples", "0.9€", "12"));
		fruits.add(new Fruit("Oranges", "1€", "25"));
	}

	@ApiOperation(value = "Get list of fruits in the System ", response = Iterable.class, tags = "getFruits")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	
	/**
	 * Get all data about Fruits
	 * @return fruits
	 */
	@RequestMapping(value = "/getFruits")
	public List<Fruit> getFruits() {
		return fruits;
	}
	
	/**
	 * Get fruit by name
	 * @param name
	 * @return fruit
	 */
	@ApiOperation(value = "Get specific fruit in the System ", response = Fruit.class, tags = "getFruit")
	@RequestMapping(value = "/getFruit/{name}")
	public Fruit getFruit(@PathVariable(value = "name") String name) {
		return fruits.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	
	/**
	 * Get fruit by quantity
	 * @param quantity
	 * @return fruitsByQuantity
	 */
	@ApiOperation(value = "Get specific fruit By quantity in the System ", response = Fruit.class, tags = "getFruitByQuantity")
	@RequestMapping(value = "/getFruitByQuantity/{quantity}")
	public List<Fruit> getFruitByQuantity(@PathVariable(value = "quantity") String quantity) {
		System.out.println("Searching Fruit in quantity : " + quantity);
		List<Fruit> fruitsByQuantity = fruits.stream().filter(x -> x.getQuantity().equalsIgnoreCase(quantity))
				.collect(Collectors.toList());
		System.out.println(fruitsByQuantity);
		return fruitsByQuantity;
	}

	
		/**
		 * Get fruit by price
		 * @param price
		 * @return fruitsByPrice
		 */
	// @ApiOperation(value = "Get specific Fruit By price in the System ",response = Fruit.class,tags="getFruitByPrice")
		@RequestMapping(value = "/getFruitByPrice/{price}")
		public List<Fruit> getFruitByPrice(@PathVariable(value = "price") String price) {
			return fruits.stream().filter(x -> x.getPrice().equalsIgnoreCase(price)).collect(Collectors.toList());
		}

}
