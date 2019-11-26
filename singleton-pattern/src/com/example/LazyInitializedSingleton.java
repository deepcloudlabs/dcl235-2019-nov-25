package com.example;

public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance = null;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null)
			instance = new LazyInitializedSingleton();
		return instance;
	}

}
