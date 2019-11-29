package com.example;

public class ForLoop1 {

	public static void main(String[] args) {
		int sum=0;
		for (byte b=-128;b<128;b++) {
//			System.err.println("b="+b);
			sum += b;
		}
		System.out.println("sum= "+sum);
	}

}
