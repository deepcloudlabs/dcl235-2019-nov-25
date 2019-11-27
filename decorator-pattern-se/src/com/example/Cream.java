package com.example;

public class Cream implements Coffee {
	private Coffee coffee;
	
	public Cream(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double cost() {
		return this.coffee.cost() + 2.5;
	}

}
