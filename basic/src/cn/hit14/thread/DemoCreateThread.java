package cn.hit14.thread;

public class DemoCreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ",执行第"+(i+1)+"次");
            }
        }, "线程1");
        t1.start();
    }
}
