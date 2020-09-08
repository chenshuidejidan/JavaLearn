package cn.hit09.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DemoPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(1000);
        queue.add(5);
        queue.add(100);

        queue.add(20);
        System.out.println(queue);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        queue.add(1);

    }

}
