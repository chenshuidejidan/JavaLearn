package test;

import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: c
 * @Date: 2021/7/18 - 07 - 18 - 9:50
 * @Description: test
 * @Version: 1.0
 */
public class PriorityQueue_ {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2)->o2-o1);
        q.offer(1);
        q.offer(5);
        q.offer(3);
        System.out.println(q.poll());
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "";
            }
        });
        new Thread(ft).start();
        try {
            ft.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
