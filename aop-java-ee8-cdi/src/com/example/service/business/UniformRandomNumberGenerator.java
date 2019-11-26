package com.example.service.business;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import com.example.aop.Profile;
import com.example.service.RandomNumberGenerator;

@Named
@Singleton
public class UniformRandomNumberGenerator implements RandomNumberGenerator {
	private static final Random random = new SecureRandom();

	@Override
	@Profile(TimeUnit.MICROSECONDS)
	public int generateRandomInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

}
