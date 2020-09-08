package cn.hit14.producerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Demo main = new Demo();
        // 创建线程并启动
        Thread t = new Thread(main.runnable);
        System.out.println("This is main ");
        t.start();
        try {
            Thread.sleep(3000);     //main睡3秒
        } catch (InterruptedException e) {
            System.out.println("In main");
            e.printStackTrace();
        }
        t.interrupt();      //中断t
    }

    Runnable runnable = () -> {
        int i = 0;
        try {
            while (i < 1000) {
                Thread.sleep(500);
                System.out.println(i++);
            }
        } catch (InterruptedException e) {
            // 判断该阻塞线程是否还在
            System.out.println(Thread.currentThread().isAlive());
            // 判断该线程的中断标志位状态
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("In Runnable");
            e.printStackTrace();
        }
    };
}