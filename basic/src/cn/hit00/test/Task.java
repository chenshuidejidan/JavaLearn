package cn.hit00.test;

class Task implements Runnable {
    public static long value;
    //public static volatile int a;
    public void run() {
        while (DemoVolatile.flag) {
            value++;
        }
        System.out.println(DemoVolatile.num);
    }
}
