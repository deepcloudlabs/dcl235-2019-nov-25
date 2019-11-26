package com.example;

public class ThreadSafeInnerClassSingleton {

	private ThreadSafeInnerClassSingleton() {
	}

	private static class SingletonHelper {
		private static ThreadSafeInnerClassSingleton instance = new ThreadSafeInnerClassSingleton();
	}

	public static ThreadSafeInnerClassSingleton getInstance() {
		return SingletonHelper.instance;
	}

}
