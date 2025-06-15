package com.study.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class PerfectSingleton implements Serializable {

	private static final long serialVersionUID = -7799682350892743070L;

	private static volatile PerfectSingleton instance = null;

	private PerfectSingleton() {
		if (instance != null) {
			throw new IllegalStateException("Singleton instance already created");
		}
	}

	public static PerfectSingleton getInstance() {
		if (instance == null) {
			synchronized (PerfectSingleton.class) {
				if (instance == null) {
					instance = new PerfectSingleton();
				}
			}
		}
		return instance;
	}

	private Object readResolve() throws ObjectStreamException {
		return getInstance();
	}

	
}
