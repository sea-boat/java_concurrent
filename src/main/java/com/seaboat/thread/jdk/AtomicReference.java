package com.seaboat.thread.jdk;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class AtomicReference<V> {
	private static final VarHandle VALUE;
	static {
		try {
			MethodHandles.Lookup l = MethodHandles.lookup();
			VALUE = l.findVarHandle(AtomicReference.class, "value", Object.class);
		} catch (ReflectiveOperationException e) {
			throw new Error(e);
		}
	}

	private volatile V value;

	public AtomicReference() {
	}

	public AtomicReference(V initialValue) {
		value = initialValue;
	}

	public final V get() {
		return value;
	}

	public final boolean compareAndSet(V expectedValue, V newValue) {
		return VALUE.compareAndSet(this, expectedValue, newValue);
	}

}
