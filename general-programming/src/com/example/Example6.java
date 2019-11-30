package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class Example6 {
	private static Integer counter;

	public static void fun(List<Double> numbers) {
		System.out.println("fun(List<Integer> numbers)");
	}

	public static void fun(Set<Integer> numbers) {
		System.out.println("fun(Set<Integer> numbers)");
	}

	public static void fun(Collection<Integer> numbers) {
		System.out.println("fun(Collection<Integer> numbers)");
	}

	public static void main(String[] args) {
		List<Collection<Integer>> o = Arrays.asList(new HashSet<Integer>(), new ArrayList<Integer>());
		A a = new B();
		for (Collection<Integer> c : o)
			// fun(c);
			a.fun(c);
//		if (counter == null) {
//			System.out.println("Hello Jupiter!");
//		} else if (counter.intValue() == 42) {
//			System.out.println("Hello Mars!");
//		}
//		fun(new TreeSet<Integer>());
		List<Double> x = new ArrayList<>(); // Java SE 7
		var y = new ArrayList<Long>();
		y.add(3L);
		System.out.println(y.getClass());
		for (var m : y) {
			System.out.println(m.getClass());
		}
		fun(x);
	}

}

class A {
	public void fun(List<Integer> numbers) {
		System.out.println("A::fun(List<Integer> numbers)");
	}

	public void fun(Set<Integer> numbers) {
		System.out.println("A::fun(Set<Integer> numbers)");
	}

	public void fun(Collection<Integer> numbers) {
		System.out.println("A::fun(Collection<Integer> numbers)");
	}

}

class B extends A {
	public void fun(List<Integer> numbers) {
		System.out.println("B::fun(List<Integer> numbers)");
	}

	public void fun(Set<Integer> numbers) {
		System.out.println("B::fun(Set<Integer> numbers)");
	}

	public void fun(Collection<Integer> numbers) {
		System.out.println("B::fun(Collection<Integer> numbers)");
	}

}