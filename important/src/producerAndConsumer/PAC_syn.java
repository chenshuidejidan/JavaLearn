package producerAndConsumer;

import java.util.concurrent.TimeUnit;

public class PAC_syn {
    private volatile static int product = 5;
    private static final int MAX_PRODUCT = 5;
    private static final Object obj = new Object();

    public static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    while (product > 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                        product++;
                        System.out.println(Thread.currentThread().getName() + "生产了一件产品，剩余" + product);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notifyAll();
                }

            }
        }
    }

    public static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (obj) {
                    while (product <= 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product--;
                    System.out.println(Thread.currentThread().getName() + "消耗了一件产品，剩余" + product);
                    obj.notifyAll();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Producer(), "生产者2").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Consumer(), "消费者2").start();
    }
}
