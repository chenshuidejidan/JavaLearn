package cn.hit18.threads.threadPool;

import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            return "Some Value";
        });
        String s = future.get();
        System.out.println(s);
    }
}
