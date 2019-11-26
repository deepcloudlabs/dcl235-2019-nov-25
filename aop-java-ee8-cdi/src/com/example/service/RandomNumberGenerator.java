package com.example.service;

public interface RandomNumberGenerator {
	default int generateRandomInt(int max) {
		return this.generateRandomInt(1, max);
	};

	int generateRandomInt(int min, int max);
}
