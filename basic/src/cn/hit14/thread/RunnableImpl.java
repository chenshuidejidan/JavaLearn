package cn.hit14.thread;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name+",执行第"+(i+1)+"次");
        }

    }
}
