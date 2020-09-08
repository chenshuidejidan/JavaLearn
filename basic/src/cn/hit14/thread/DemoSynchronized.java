package cn.hit14.thread;

import java.util.concurrent.locks.ReentrantLock;

public class DemoSynchronized {
    public synchronized void method() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("method running");
        }
    }

    public static synchronized void staticMethod() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("static method running");
        }
    }

    public static void main(String[] args) {
        new Thread(()-> {
            try {
                staticMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                new DemoSynchronized().method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
