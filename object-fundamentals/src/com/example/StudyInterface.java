package com.example;

public abstract interface StudyInterface {
	public static final int x = 42;

	void fun();

	void gun();

	/**
	 * since 2.1
	 */
	default void sun() {
		this.tun();
	} // SE 8 : API improvement

	// SE 8 : Method reference StudyInterface::run
	static void run() {
		bun();
	} // SE 8 : Utility method used in Functional Programming

	private static void bun() {
	} // SE 9 : Code duplications in public static methods

	private void tun() {
	} // SE 9 : Code duplications in default methods
}
