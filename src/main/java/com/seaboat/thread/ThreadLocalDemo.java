package com.seaboat.thread;

public class ThreadLocalDemo {

	static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			new Thread(() -> {

				threadLocal.set(Thread.currentThread().getName());

				System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());

			}).start();
	}
}
