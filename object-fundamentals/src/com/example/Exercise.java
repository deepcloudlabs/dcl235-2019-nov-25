package com.example;

public class Exercise {

	public static void main(String[] args) {
		B b = new B();
		System.out.println(b instanceof A);

	}

}

enum WEEK_DAY implements A {
	MONDAY, TUESDAY;

//	@Override
//	public void fun() {
//		
//		
//	}
}
