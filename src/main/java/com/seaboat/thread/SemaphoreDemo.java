package com.seaboat.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreDemo {
	static Semaphore semaphore = new Semaphore(5);
	static AtomicInteger value = new AtomicInteger(0);

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println("counting number : " + value.incrementAndGet());
					Thread.sleep(5000);
					semaphore.release();
				} catch (InterruptedException e) {
				}
			});
			thread.start();
		}
	}
}
