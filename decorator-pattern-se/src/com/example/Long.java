package com.example;

public class Long implements Coffee {
	private Coffee coffee;
	
	public Long(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double cost() {
		return this.coffee.cost() * 1.5;
	}

}
