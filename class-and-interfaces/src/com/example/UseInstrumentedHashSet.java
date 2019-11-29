package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UseInstrumentedHashSet {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		InstrumentedHashSet<Integer> set = new InstrumentedHashSet<>(hashSet);
		set.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		hashSet.add(7);
		System.out.println(set.getCounter());
		fun(set);
		List<Integer> list = new ArrayList<>();
		list.add(4);
		Integer o = list.get(2);

	}

	public static void fun(Set<Integer> numbers) {
	}

}
