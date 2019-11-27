package com.example;

public class Sugar implements Coffee {
	private Coffee coffee;
	
	public Sugar(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double cost() {
		return this.coffee.cost() + 0.5 ;
	}

}
