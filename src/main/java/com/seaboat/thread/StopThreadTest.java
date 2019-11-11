package com.seaboat.thread;

class StopThread extends Thread {
	private volatile boolean exit = false;

	public void stopThread() {
		exit = true;
	}

	@Override
	public void run() {
		while (!exit) {
			System.out.println("Thread is running....");
		}
		System.out.println("Thread Stopped.... ");
	}
}

public class StopThreadTest {
	public static void main(String args[]) {
		StopThread thread = new StopThread();
		thread.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.stopThread();
	}
}