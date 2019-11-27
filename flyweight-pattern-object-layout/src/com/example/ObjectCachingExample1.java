package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class ObjectCachingExample1 {
	public static void main(String[] args) throws Exception {
		String s1 = "Jack";
		String s2 = new String("Jack");
		String s3 = "Jack";
		System.err.println("s1 == s2 : " + (s1 == s2));
		System.err.println("s1 == s3 : " + (s1 == s3));
		s2 = s2.intern();
		System.err.println("s1 == s2 : " + (s1 == s2));
		System.err.println("s1 == s3 : " + (s1 == s3));
	}

}
