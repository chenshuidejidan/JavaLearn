package cn.hit14.atomic;

public class DemoVolatile4 {


    private static boolean flag = true;

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (flag) {
                i++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("**********test3 跳出成功, i=%d **********\n", i);
        });
        thread.start();
        Thread.sleep(100);
        flag = false;
        System.out.printf("**********test3 main thread 结束, i=%d **********\n", i);
    }
}
