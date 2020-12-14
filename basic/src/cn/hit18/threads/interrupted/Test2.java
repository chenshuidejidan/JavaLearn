package cn.hit18.threads.interrupted;

import java.util.concurrent.TimeUnit;

public class Test2 {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

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
                    synchronized (lock1){
                        System.out.println(t.getName() + "获得第一把锁");
                        TimeUnit.SECONDS.sleep(1);
                        synchronized(lock2){
                            System.out.println(t.getName() + "获得第二把锁");
                        }
                    }
                } else {
                    synchronized (lock2){
                        System.out.println(t.getName() + "获得第二把锁");
                        TimeUnit.SECONDS.sleep(1);
                        synchronized(lock1){
                            System.out.println(t.getName() + "获得第一把锁");
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(t.getName() + "被中断，中断标志为" + t.isInterrupted());
                t.interrupt();
                e.printStackTrace();
            } finally {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T(1), "thread1");
        Thread t2 = new Thread(new T(2), "thread2");
        t1.start();
        t2.start();
        Thread.sleep(500);
        //t2.interrupt();
    }

}

