package cn.hit14.producerAndConsumer;


public class Producer implements Runnable {

    private Product product;

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (product.isFull()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!product.isFull()) {
                    produce();
                }
                product.notify();
            }
        }
    }

    Producer(Product product) {
        this.product = product;
    }

    void produce() {
        if (product.isFull()) {
            System.out.println("警告：满了，不能再生产了");
            throw new IndexOutOfBoundsException();
        } else {
            product.add();
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "花费1秒生产了一个产品,现在共有" + product.getCount() + "个");
    }
}

