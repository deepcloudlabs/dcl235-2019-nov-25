package com.example;

public abstract class StudyAbstract {
	private int data;

	public StudyAbstract(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public abstract void fun();

	protected abstract void gun();
}
