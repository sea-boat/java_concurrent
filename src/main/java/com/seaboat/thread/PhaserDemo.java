package com.seaboat.thread;

import java.io.IOException;
import java.util.concurrent.Phaser;

public class PhaserDemo {
	public static void main(String[] args) throws IOException {

		int repeats = 3;

		Phaser phaser = new Phaser() {
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println(
						"---------------PHASE[" + phase + "],Parties[" + registeredParties + "] ---------------");
				return phase + 1 >= repeats || registeredParties == 0;
			}
		};
		for (int i = 0; i < 10; i++) {
			phaser.register();
			new Thread(new Task3(phaser), "Thread-" + i).start();
		}
	}
}

class Task3 implements Runnable {
	private final Phaser phaser;

	Task3(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {
		while (!phaser.isTerminated()) {
			int i = phaser.arriveAndAwaitAdvance();
			System.out.println(Thread.currentThread().getName() + ": 执行完任务");
		}
	}
}
