package cn.hit00.test;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 10:49
 * @Description: cn.hit00.test
 * @Version: 1.0
 */
public class ProducerAndConsumer {
    private int MAX_PRODUCT;
    private Object obj = new Object();
    protected volatile int product = 0;

    public static void main(String[] args) {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        new Thread(()->producerAndConsumer.produce()).start();
        new Thread(()->producerAndConsumer.consume()).start();
    }

    private void produce() {
        synchronized (obj) {
            while (true) {
                while (product > 0) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product++;
                System.out.println("生产了一件产品，现有" + product);
                obj.notifyAll();
            }
        }
    }

    private void consume() {
        synchronized (obj) {
            while (true) {
                while (product <= 0) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product--;
                System.out.println("消费了一件产品，现有" + product);
                obj.notifyAll();
            }
        }
    }
}
