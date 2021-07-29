package interview;

/**
 * @Auther: c
 * @Date: 2021/7/19 - 07 - 19 - 20:50
 * @Description: interview
 * @Version: 1.0
 */
public class ProducerAndConsumer {
    public static volatile Object lock = new Object();
    public static volatile int count = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while(true) {
                synchronized (lock){
                    while(count>0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + " 生产1， count=" + count);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }

        }, "生产者").start();

        new Thread(()-> {
            while(true){
                synchronized (lock){
                    while(count<=0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + " 消费1， count=" + count);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }

        }, "消费者").start();

    }
}