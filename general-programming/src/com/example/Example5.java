package com.example;

public class Example5 {

	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			System.out.println(b);
//            if (b == (byte)0x90) // -112
            	if (b == 0x90) // 144
                System.out.print("Joy!");
        }
	}

}
