package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Customer {
	private static final Integer ARRAY[] = {4,8,15,16,23,42};

	public static Integer getArray(int i) {
		return ARRAY[i];
	}
	public static Integer[] getArray() {
		return Arrays.copyOfRange(ARRAY, 0, ARRAY.length);
	}
	public static List<Integer> getList() {
		return Collections.unmodifiableList(Arrays.asList(ARRAY));
	}
	public static Integer[] getArray2() {
		return ARRAY.clone();
	}
	
}
