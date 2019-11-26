package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Stream;

public class BusinessService {
	// overload
	public double computeTax(Employee... employees) { // 1
		System.err.println("computeTax(Employee... employees)");
		return computeTax(Arrays.asList(employees));
	}

	public double computeTax(Iterable<Employee> employees) { // 2
		System.err.println("computeTax(Iterable<Employee> employees)");
		double totalTax = 0;
		for (Employee emp : employees) {
			totalTax += emp.getSalary() * getRatio(emp);
		}
		return totalTax;
	}

	public double computeTax(Collection<Employee> employees) { // 3
		System.err.println("computeTax(Collection<Employee> employees)");
		Stream<Employee> stream;
		if (employees.size() > 10_000)
			stream = employees.parallelStream();
		else
			stream = employees.stream();
		return stream.mapToDouble(emp -> emp.getSalary() * getRatio(emp)).sum();
	}

	public double computeTax(List<Employee> employees) { // 4
		System.err.println("computeTax(List<Employee> employees)");
		return employees.stream().mapToDouble(emp -> emp.getSalary() * getRatio(emp)).sum();
	}

	public double computeTax(Stream<Employee> employees) { // 5
		return employees.mapToDouble(emp -> emp.getSalary() * getRatio(emp)).sum();
	}

	private double getRatio(Employee emp) {
		return 0.2;
	}

	public double calculate(Iterator<Employee> employees) {
		double total = 0;
		while (employees.hasNext()) {
			Employee emp = employees.next();
			total += emp.getSalary();
		}
		return total;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BusinessService srv = new BusinessService();
		Iterable<Employee> employees1 = new TreeSet<>();
		List<Employee> employees2 = new ArrayList<>();
		Deque<Employee> employees3 = new ArrayDeque<>();
		Vector<Employee> employees4 = new Vector<>();
		Employee employeeArray[] = new Employee[] {};
		srv.computeTax(employees1); // 2
		srv.computeTax(employees2); // 4
		srv.computeTax(employees3); // 3
		Enumeration<Employee> employees5 = null;
		Enumeration2IteratorAdapter<Employee> adapter = new Enumeration2IteratorAdapter<>(employees5);
		srv.calculate(adapter); // ?
		srv.computeTax(employeeArray); // 1 -> 4
		srv.computeTax(new Employee(), new Employee());
	}
}

// Thread Safe Adapter
class Enumeration2IteratorAdapter<T> implements Iterator<T> {
	private final Enumeration<T> adaptee;

	public Enumeration2IteratorAdapter(Enumeration<T> adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public boolean hasNext() {
		synchronized (adaptee) {
			return adaptee.hasMoreElements();
		}
	}

	@Override
	public T next() {
		synchronized (adaptee) {
			return adaptee.nextElement();
		}
	}

}
