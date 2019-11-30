package com.example;

@SuppressWarnings("finally")
public class CatchMeIfYouCan2 {
	public static int haveFun() {
		try {
			System.exit(108);
		} finally {
			return 42;
		}
	}

	public static void main(String[] args) {
		System.out.println(haveFun());
	}
}
