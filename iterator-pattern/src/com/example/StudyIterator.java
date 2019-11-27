package com.example;

import java.util.List;

public class StudyIterator {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 23, 42, 15, 16);
		// outer loop #1
		for (var iter = numbers.iterator(); iter.hasNext();) {
			var x = iter.next();
			System.out.println("x=" + x);
		}
		// outer loop #2 (SE 5)
		for (var x : numbers) {
			System.out.println("x=" + x);
		}
		// inner loop #1 (SE 8)
		numbers.forEach(System.out::println);
		// inner loop #2 (SE 8)
		numbers.stream().forEach(System.out::println);
		// inner loop #3 (SE 8)
		numbers.parallelStream().forEach(System.out::println);
	}

}
