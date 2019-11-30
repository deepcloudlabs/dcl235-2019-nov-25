package com.example;

public class TryCatch {
	public static void fun() throws E2 {
		throw new E2();
	}

	public static void main(String[] args) {
		try {
			fun();
		} catch (E3 e) {
		} catch (E2 e) {
			e.printStackTrace();
		}

	}

}

@SuppressWarnings("serial")
class E1 extends Exception {
}

@SuppressWarnings("serial")
class E2 extends E1 {
}

@SuppressWarnings("serial")
class E3 extends E2 {
}