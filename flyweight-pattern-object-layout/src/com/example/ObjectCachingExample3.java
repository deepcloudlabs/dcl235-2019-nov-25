package com.example;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class ObjectCachingExample3 {
	// -XX:AutoBoxCacheMax=1024
	public static void main(String[] args) throws Exception {
		Integer x = Integer.valueOf(42);
		Integer y = 42;
		Integer u = 549;
		Integer v = 549;
		System.err.println("x==y: " + (x == y));
		System.err.println("u==v: " + (u == v));

	}

}
