package cn.hit00.test;

public class Demo {
    static class Task implements Runnable {
        public static volatile long value;

        public void run() {
            while (Demo.flag) {
                value++;
            }
            System.out.println(num);
        }
    }

    public static boolean flag = true;
    public static int num;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task()).start();
        Thread.sleep(1000);
        flag = false;
        //Thread.sleep(1);
        num = 120;
        System.out.println("flag: " + flag);
        System.out.println("value: " + Task.value);
        Thread.sleep(1500);
        System.out.println("value: " + Task.value);
    }
}
