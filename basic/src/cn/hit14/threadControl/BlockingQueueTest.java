package cn.hit14.threadControl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class Student implements Runnable {
    private Object wan = new Object();
    public void run() {
        try {
            System.out.println("学生：取到了一个碗");
            BlockingQueueTest.wanQueue.put(wan);
            System.out.println("学生：阿姨帮忙盛饭");
            wan = BlockingQueueTest.wanWithFanQueue.take();
            System.out.println("学生：吃饭");
        } catch (InterruptedException e) {}
    }
}
class CafeteriaWorker implements Runnable {
    public void run() {
        try {
            Object wan = BlockingQueueTest.wanQueue.take();
            System.out.println("阿姨：给学生盛饭");
            BlockingQueueTest.wanWithFanQueue.put(wan);
        } catch (InterruptedException e) {}
    }
}
public class BlockingQueueTest {
    public static BlockingQueue wanQueue = new LinkedBlockingQueue();
    public static BlockingQueue wanWithFanQueue = new LinkedBlockingQueue();
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Student());
        exec.execute(new CafeteriaWorker());
        exec.shutdown();
    }
}
