package cn.hit14.threadControl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class InterruptableThread implements Runnable {
    private int value;
    public void run() {
        Thread currentThread = Thread.currentThread();
        while(!currentThread.isInterrupted()) {     //没有收到中断信号执行循环
            value++;
        }
        System.out.println("Interrupted value = "+value); //收到中断信号打印
    }
}
class AlwaysRunThread implements Runnable {
    public void run() {     //不处理中断信号
        while(true) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Running");
        }
    }
}
public class InterruptRunningTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future interruptableFuture= exec.submit(new InterruptableThread());
        Future alwaysRunFuture= exec.submit(new AlwaysRunThread());
        exec.shutdown();
        interruptableFuture.cancel(true);
        alwaysRunFuture.cancel(true);
    }
}