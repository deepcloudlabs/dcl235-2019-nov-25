package com.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InstrumentedHashSet<E> implements Set<E> {
	private int counter = 0;
	private HashSet<E> self;

	public InstrumentedHashSet(HashSet<E> self) {
		this.self = self;
	}

	public InstrumentedHashSet() {
		self = new HashSet<>();
	}

	public InstrumentedHashSet(Collection<? extends E> c) {
		self = new HashSet<>();
		self.addAll(c);
		counter = c.size();
	}

	@Override
	public boolean add(E e) {
		this.counter++;
		return self.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		this.counter += c.size();
		return self.addAll(c);
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public int size() {
		return self.size();
	}

	@Override
	public boolean isEmpty() {
		return self.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return self.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return self.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
