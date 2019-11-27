package com.example;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Notebook implements Product {

	@Override
	public double getPrice() {
		return 10_000;
	}

	@Override
	public String getLabel() {
		return "Notebook - " + getPrice();
	}

}
