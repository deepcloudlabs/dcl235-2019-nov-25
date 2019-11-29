package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.domain.B;

public class StudyAccessControl {

	public static void main(String[] args) {
		A a= new A();
		B b= new B();
		System.out.println(a.y);
		System.out.println(a.z);
		System.out.println(a.u);
		// Error: System.out.println(b.y);
		System.out.println(b.z);
		// Error: System.out.println(b.u);
        Customer.getArray()[0] = 1;   
        new Random().ints(1,50).distinct().limit(6)
                   .sorted()
                   .boxed()
                   .collect(Collectors.toList());
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        final Integer k[] = {0};
        long counter =numbers.stream().filter(i -> i%2 == ++k[0])
                        .count();
        System.out.println(counter);
	}

}

@SuppressWarnings("unused")
class A {
	private int x;
	protected int y;
	public int z;
	int u;
}
