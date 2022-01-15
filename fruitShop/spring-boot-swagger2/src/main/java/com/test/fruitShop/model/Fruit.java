package com.test.fruitShop.model;

import io.swagger.annotations.ApiModelProperty;

public class Fruit {
	@ApiModelProperty(notes = "Name of the Fruit",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Price of the Fruit",name="price",required=true,value="test price")
	private String price;
	@ApiModelProperty(notes = "Quantity of the Fruit",name="quantity",required=true,value="test quantity")
	private String quantity;

	public Fruit(String name, String price, String quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
