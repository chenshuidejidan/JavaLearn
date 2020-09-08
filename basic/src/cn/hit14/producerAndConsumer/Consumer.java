package cn.hit14.producerAndConsumer;


public class Consumer implements Runnable {
    private Product product;

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                while (product.isEmpty()) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (!product.isEmpty()) {
                    consume();

                }
                product.notify();
            }
        }
    }

    Consumer(Product product) {
        this.product = product;
    }

    void consume() {
        if (product.isEmpty()) {
            System.out.println("警告：空了，不能再消费了");
            throw new IndexOutOfBoundsException();
        } else {
            product.subtract();

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "花费1秒消耗了一个产品,现在共有" + product.getCount() + "个");
        }
    }

}
