package cn.hit18.threads.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    static Semaphore semaphore = new Semaphore(2);

    static class Task implements Runnable{

        @Override
        public void run() {
            boolean acquireSuccess = false;
            try {
                semaphore.acquire();
                acquireSuccess = true;
                System.out.println(Thread.currentThread().getName()+"获取了一个信号量，剩余"+semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                if (acquireSuccess) {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"释放了一个信号量，剩余"+semaphore.availablePermits());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Task()).start();
            Thread.sleep(100);
        }
    }
}
