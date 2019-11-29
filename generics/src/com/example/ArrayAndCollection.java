package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ArrayAndCollection {

	public static void main(String[] args) {
		Class<?> clazz = void.class;
		Object o[] = new Long[1];
		System.out.println(o.getClass());
		Boolean b = Boolean.valueOf(true);
		System.out.println(b.getClass());
//		o[0] = b;
		List<Number> list = new ArrayList<>();
		list.add(42);
		list.add(3.14);
		list.add(42L);
//		list.add(true);
		writeObjectToFile(new A());
		short k = -1;
		char c = (char) k;
		System.out.println(k);
		System.out.println(c + 0);
		short s = (short) c;
		System.out.println(s);
	}

	public static void writeObjectToFile(Serializable o) {

	}
}

@SuppressWarnings("serial")
class A implements Serializable {
}