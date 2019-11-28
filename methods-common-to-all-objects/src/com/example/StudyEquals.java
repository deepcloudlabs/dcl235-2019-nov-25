package com.example;

import java.util.Objects;

public class StudyEquals {

	public static void main(String[] args) {
		Object o1= new Object();
		Object o2= new Object();
		System.out.println("o1.equals(o2): "+o1.equals(o2));
		A a1= new A(42);
		A a2 = new A(42);
		A a3 = new A(42);
		System.out.println("a1.equals(a2): "+a1.equals(a2));
		System.out.println("a2.equals(a1): "+a2.equals(a1));
		System.out.println("a2.equals(a3): "+a2.equals(a3));
		System.out.println("a1.equals(a3): "+a1.equals(a3));	
		B b1 = new B(42,108);
		System.out.println("a1.equals(b1): "+a1.equals(b1));
		System.out.println("b1.equals(a1): "+b1.equals(a1));
		
	}

}

class A extends Object {
	private int id;
	
	public A(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object other) {
		if (Objects.isNull(other)) return false;
		if (this==other) return true;
		if (!this.getClass().equals(other.getClass())) return false;
		return this.id== ((A)other).id;
	}
	
}

class B extends A {
	private int id2;

	public B(int id, int id2) {
		super(id);
		this.id2 = id2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		B other = (B) obj;
		if (id2 != other.id2)
			return false;
		return true;
	}

//	@Override
//	public boolean equals(Object other) {
//		if (Objects.isNull(other)) return false;
//		if (this==other) return true;
//		if (!this.getClass().equals(other.getClass())) return false;
//		return super.equals(other) && this.id2==((B)other).id2;
//	}
	
}