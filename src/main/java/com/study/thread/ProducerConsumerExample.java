package com.study.thread;

public class ProducerConsumerExample {
    private static final Object lock = new Object();
    private static int data = 0;
    private static boolean hasData = false;

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                synchronized (lock) {
                    while (hasData) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                    data = i;
                    hasData = true;
                    System.out.println(Thread.currentThread().getName() + " produced: " + data);
                    lock.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                synchronized (lock) {
                    while (!hasData) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " consumed: " + data);
                    hasData = false;
                    lock.notify();
                }
            }
        }
    }
}
