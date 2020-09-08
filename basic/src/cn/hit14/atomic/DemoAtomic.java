package cn.hit14.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoAtomic {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Count count = new Count();
        // 100个线程对共享变量进行加1
        for (int i = 0; i < 100; i++) {
            service.execute(() -> count.increase());
        }
        // 等待上述的线程执行完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(count.getCount());
    }

    static class Count {
        // 共享变量
        private AtomicInteger count = new AtomicInteger(0);

        public AtomicInteger getCount() {
            return count;
        }

        public synchronized void increase() {
            count.incrementAndGet();    //返回新值
            //count.getAndIncrement();  返回旧值
        }
    }
}