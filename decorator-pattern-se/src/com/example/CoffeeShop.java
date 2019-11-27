package com.example;

import java.util.List;

public class CoffeeShop {

	public static void main(String[] args) {
		List<Coffee> coffees = List.of(
				new Cream(new Sugar(new Sugar(new TurkishCoffee()))),
				new Long(new Cream(new Espresso()))
		);
		System.out.println(coffees.stream().mapToDouble(Coffee::cost).sum());

	}

}
