package cn.hit14.pool;

import java.util.concurrent.*;

public class DemoCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<String> submit1 = pool.submit(new MyCallable(200));
        Future<String> submit2 = pool.submit(new MyCallable(100));
        //打印返回值
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        //结束
        pool.shutdown();
    }
}
