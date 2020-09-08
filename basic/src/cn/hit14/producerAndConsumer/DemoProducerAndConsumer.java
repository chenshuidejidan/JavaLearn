package cn.hit14.producerAndConsumer;

public class DemoProducerAndConsumer {
    public static void main(String[] args) {
        Product p1 = new Product();
        Runnable producerRunnable = new Producer(p1);
        Runnable consumerRunnable = new Consumer(p1);
        new Thread(consumerRunnable, "消费者1").start();
        new Thread(consumerRunnable, "消费者2").start();
        new Thread(producerRunnable, "生产者1").start();
    }
}
