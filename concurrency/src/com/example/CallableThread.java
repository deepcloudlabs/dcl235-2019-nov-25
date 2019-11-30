package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class CallableThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService srv = Executors.newWorkStealingPool();
		FutureTask<Integer> task = new FutureTask<>(new CallableTask());
		srv.submit(task);
//		new Thread(task).start();
		while (!task.isDone()) {
			System.out.println("Working hard!");
			TimeUnit.MILLISECONDS.sleep(10);
		}
		System.out.println(task.get());
//		int counter = 0;
//		while (true) {
//			try {
//				int result = task.get(10, TimeUnit.MILLISECONDS);
//				System.out.println(result);
//				break;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			} catch (TimeoutException e) {
//				counter++;
//				if (counter > 5)
//				   task.cancel(false);
//				System.out.println("Working hard...");
//			}
//		}
		System.out.println("Done.");
		srv.shutdown();
	}

}

class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		TimeUnit.MILLISECONDS.sleep(100);
		return 42;
	}

}
