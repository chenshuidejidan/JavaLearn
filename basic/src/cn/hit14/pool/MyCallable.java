package cn.hit14.pool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int number;
    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum+=i;
        }
        return String.valueOf(sum)+"\t"+Thread.currentThread().getName();
    }
}
