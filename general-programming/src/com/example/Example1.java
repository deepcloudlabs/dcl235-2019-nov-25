package com.example;

public class Example1 {
	public static void main(String[] args) {
		int x=0b0000_0011,y =0b0000_0101;
		System.out.println("x= "+x+", y="+y);
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x= "+x+", y="+y);	
	    byte b = (byte) 0b1111_1111;
	    System.out.println(b);
	    
	}
}
