package cn.hit18.threads.interrupted;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static class T implements Runnable {
        int lock;

        public T(int lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            Thread t = Thread.currentThread();

            try {
                if (lock == 1) {
                    lock1.lockInterruptibly();
                    System.out.println(t.getName() + "获得第一把锁");
                    TimeUnit.SECONDS.sleep(1);
                    lock2.lockInterruptibly();
                    System.out.println(t.getName() + "获得第二把锁");
                } else {
                    lock2.lockInterruptibly();
                    System.out.println(t.getName() + "获得第二把锁");
                    TimeUnit.SECONDS.sleep(1);
                    lock1.lockInterruptibly();
                    System.out.println(t.getName() + "获得第一把锁");
                }
            } catch (InterruptedException e) {
                System.out.println(t.getName() + "被中断，中断标志为" + t.isInterrupted());
                t.interrupt();
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) lock1.unlock();
                if (lock2.isHeldByCurrentThread()) lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T(1), "thread1");
        Thread t2 = new Thread(new T(2), "thread2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
    }

}

