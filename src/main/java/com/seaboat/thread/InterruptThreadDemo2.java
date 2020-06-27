package com.seaboat.thread;

class StopThreadInterrupt extends Thread {
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			System.out.println("Thread is running....");
		}
		System.out.println("Thread Stopped.... ");
	}
}

public class StopThreadInterruptTest {
	public static void main(String args[]) {
		StopThreadInterrupt thread = new StopThreadInterrupt();
		thread.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
