package com.seaboat.thread;

public class TestThread {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup());
		new MyThread().start();
	}

	static class MyThread extends Thread {
		public void run() {
			System.out.println("..........."+this.getThreadGroup());
		}
	}

}
