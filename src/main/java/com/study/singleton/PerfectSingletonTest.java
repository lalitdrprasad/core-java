package com.study.singleton;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PerfectSingletonTest {

	@Test
	@DisplayName("Break Singleton Behaviour Using Reflection")
	void test() throws InterruptedException {
		List<PerfectSingleton> instanceList = new CopyOnWriteArrayList<>();
		int numberOfThreads = 5;
		CountDownLatch latch = new CountDownLatch(numberOfThreads);

		Runnable task = () -> {
			try {

				Constructor<PerfectSingleton> constructor = PerfectSingleton.class.getDeclaredConstructor();
				constructor.setAccessible(true);
				PerfectSingleton newInstance = constructor.newInstance();
				instanceList.add(newInstance);

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException | NoSuchMethodException e) {
				System.out.println("==========================\nException Occurred");
			}
			latch.countDown();
		};

		IntStream.range(0, numberOfThreads).forEach(i -> new Thread(task).start());

		latch.await();

		PerfectSingleton firstInstance = instanceList.get(0);

		boolean isSignleton = instanceList.stream().allMatch(instance -> instance == firstInstance);

		if (!isSignleton) {
			System.out.println("Not a Singleton Class");
		}
		assertTrue(isSignleton);
		System.out.println("Total Instances: " + instanceList.size());
		instanceList.forEach(System.out::println);

	}

}
