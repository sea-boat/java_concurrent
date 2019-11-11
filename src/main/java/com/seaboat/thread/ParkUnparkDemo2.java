package com.seaboat.thread;

import java.util.concurrent.locks.LockSupport;

public class ParkUnparkDemo2 {

	public static void main(String[] args) {
		LockSupport.unpark(Thread.currentThread());
		LockSupport.unpark(Thread.currentThread());
		LockSupport.unpark(Thread.currentThread());
		LockSupport.unpark(Thread.currentThread());
		LockSupport.unpark(Thread.currentThread());
		LockSupport.park();
		LockSupport.park();
	}
}
