package com.example;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class Discount implements Product {
	@Any
	@Inject
	@Delegate
	private Product product;

	@Override
	public double getPrice() {
		return product.getPrice() * 0.7;
	}

	@Override
	public String getLabel() {
		return product.getLabel() + " !!! Discount: " + this.getPrice();
	}

}
