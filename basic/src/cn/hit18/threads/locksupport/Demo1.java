package cn.hit18.threads.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("park()之前中断标志：" + Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println("park()之后中断标志：" + Thread.currentThread().isInterrupted());
        });
        t1.setName("t1");
        t1.start();
        //休眠5秒
        TimeUnit.SECONDS.sleep(5);
        t1.interrupt();
    }
}
