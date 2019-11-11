package com.seaboat.thread;

public class SuspendResumeThread{
    public static void main (String args[]) throws InterruptedException{
		Thread2 second=new Thread2();
	    second.start();
        Thread.sleep(3000);
		second.resume();
	}

    static class Thread2 extends Thread {
	    public void run() {
		    System.out.println("Second thread is suspended itself");
		    suspend();
		    System.out.println("Second thread runs again");
	    }
    }
}
