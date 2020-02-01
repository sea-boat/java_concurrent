package com.seaboat.thread;

public class AtomicReferenceDemo3 {

	static String[] names = { "tom", "jack", "lucy" };
	static Baoshu bs = new Baoshu();
	static AtomicReference<Baoshu> atomicBS = new AtomicReference<Baoshu>(bs);

	public static void main(String[] args) throws InterruptedException {
		for (String name : names) {
			new Thread(() -> {
				for (;;) {
					Baoshu newbs = new Baoshu();
					newbs.name = name;
					newbs.num = atomicBS.get().num + 1;
					if (atomicBS.compareAndSet(bs, newbs)) {
						System.out.println(atomicBS.get().toString());
						bs = atomicBS.get();
						break;
					}
				}
			}).start();
		}
		Thread.sleep(3000);
	}

	static class Baoshu {

		private String name;
		private int num = 0;

		public String toString() {
			return name + " : " + num;
		}
	}
}
