package com.example.service.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import com.example.service.RandomNumberGenerator;

@Decorator
public class RandomNumberDecorator implements RandomNumberGenerator {

	@Inject
	@Delegate
	@Any
	RandomNumberGenerator generator;

	@Override
	public int generateRandomInt(int min, int max) {
		System.err.println("RandomNumberDecorator is running.");
		return generator.generateRandomInt(min - 1, max + 1);
	}

}
