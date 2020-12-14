package producerAndConsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {
    private volatile static int product = 3;
    private static final int MAX_PRODUCT = 3;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    public static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try{
                    lock.lock();
                    while(product>=MAX_PRODUCT){
                        notFull.await();
                    }
                    TimeUnit.SECONDS.sleep(1);
                    product++;
                    System.out.println(Thread.currentThread().getName()+"生产了一个产品，余："+product);
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try{
                    lock.lock();
                    while(product<=0){
                        notEmpty.await();
                    }
                    TimeUnit.SECONDS.sleep(1);
                    product--;
                    System.out.println(Thread.currentThread().getName()+"消耗了一个产品，余："+product);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            new Thread(new Producer(),"生产者"+i).start();
        }
        for (int j = 1; j <= 10; j++) {
            new Thread(new Consumer(),"消费者"+j).start();
        }
    }
}
