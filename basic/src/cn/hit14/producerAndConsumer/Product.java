package cn.hit14.producerAndConsumer;

import java.util.ArrayList;
import java.util.List;

class Product {
    private static final int MAX_CAPACITY = 1;
    private List productList = new ArrayList<>(MAX_CAPACITY);
    private int count = productList.size();

    boolean isFull() {
        return productList.size() == MAX_CAPACITY;
    }

    boolean isEmpty() {
        return productList.isEmpty();
    }


    void add() {
        productList.add(new Object());
        count = productList.size();
    }

    void subtract() {
        productList.remove(count - 1);
        count = productList.size();
    }

    public int getCount() {
        return count;
    }
}
