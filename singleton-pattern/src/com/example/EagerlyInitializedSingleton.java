package com.example;

public class EagerlyInitializedSingleton {
	private static final EagerlyInitializedSingleton instance = new EagerlyInitializedSingleton();

	private EagerlyInitializedSingleton() {
	}

	public static EagerlyInitializedSingleton getInstance() {
		return instance;
	}

}
