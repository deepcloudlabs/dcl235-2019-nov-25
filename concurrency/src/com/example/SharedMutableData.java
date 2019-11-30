package com.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SharedMutableData {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockTask task = new ReentrantLockTask();
		System.err.println(task.getSharedData());
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.err.println(task.getSharedData());
	}

}

class Task implements Runnable {
	private int sharedData = 0;

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i)
			synchronized (this) {
				this.sharedData++;
			}
	}

	public int getSharedData() {
		return sharedData;
	}

}

class AtomicTask implements Runnable {
	private AtomicInteger sharedData = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i)
			this.sharedData.incrementAndGet();
	}

	public int getSharedData() {
		return sharedData.get();
	}

}

class ReentrantLockTask implements Runnable {
	private int sharedData = 0;
	private ReentrantLock rl = new ReentrantLock();

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i) {
			rl.lock();
			try {
				// critical section
				this.sharedData++;
			} finally {
				rl.unlock();
			}
		}

	}

	public int getSharedData() {
		return sharedData;
	}

}