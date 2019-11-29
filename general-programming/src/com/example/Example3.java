package com.example;

public class Example3 {
	public static void main(String[] args) {
		int j = 0;
        for (int i = 0; i < 100; i++) {
        	 int temp = j;
        	 j = j + 1;
             j = temp;
        }
        System.out.println( j );
	}
}
