package com.example;

@SuppressWarnings("finally")
public class CatchMeIfYouCan1 {
	public static int haveFun() {
		try {
			return 108;
		} finally {
			return 42;
		}
	}

	public static void main(String[] args) {
		System.out.println(haveFun());
	}
}
