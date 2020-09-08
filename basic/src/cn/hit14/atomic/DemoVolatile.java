package cn.hit14.atomic;


public class DemoVolatile {
    static class Task implements Runnable {
        public static long value;
        //public static volatile int a;
        public void run() {
            while (DemoVolatile.flag) {
                value++;
            }
            System.out.println(num);
        }
    }

    public static boolean flag = true;
    public static int num;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task()).start();
        //Thread.sleep(1);
        flag = false;
        num = 120;
        System.out.println("flag: " + flag);
        System.out.println("value: " + Task.value);
        Thread.sleep(1500);
        System.out.println("value: " + Task.value);
    }
}
