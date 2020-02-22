package com.seaboat.thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class ThreadLocalDemo2 {

	static Map<Thread, Object> map = new Hashtable<Thread, Object>();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			new Thread(() -> {
				Thread current = Thread.currentThread();
				map.put(current, current.getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(current.getName() + "--->" + map.get(current));

			}).start();
	}
}
