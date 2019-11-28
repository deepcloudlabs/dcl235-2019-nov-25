package com.example.ccc.service.business;

import java.util.Random;

import com.example.ccc.service.RandomNumberService;

public class SimpleRandomNumberGenerator implements RandomNumberService {

	private Random random= new Random();

	@Override
	public int generate(int min, int max) {
		return min + random.nextInt(max-min+1);
	}

}
