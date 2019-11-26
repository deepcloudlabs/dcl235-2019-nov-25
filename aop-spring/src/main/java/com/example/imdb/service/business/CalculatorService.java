package com.example.imdb.service.business;

import java.util.concurrent.TimeUnit;

import com.example.imdb.aspect.Profile;
import com.example.imdb.service.Calculator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class CalculatorService implements Calculator {

	@Override
	@Profile(unit = TimeUnit.MILLISECONDS)
	public double pow(double x, double y) {
		System.err.println("CalculatorService::pow() is running...");
		return Math.pow(x, y);
	}

}
