package algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2020/12/4 - 12 - 04 - 22:49
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo146_LRU {
    private class DeList {
        public DeList pre;
        public DeList next;
        public int val;

        public DeList(int val, DeList pre, DeList next) {
            this.pre = pre;
            this.next = next;
            this.val = val;
        }
    }

    private int maxCap;
    private Map<Integer, DeList> map;
    private DeList head = new DeList(-1, null, null);
    private DeList tail = head;

    public Demo146_LRU(int capacity) {
        this.maxCap = capacity;
        this.map = new HashMap<>(capacity * 4 / 3);
    }



    public int get(int key) {
        DeList node = null;
        if ((node = map.get(key)) == null) return -1;
        if(node!=tail) moveNodeToTail(node);
        return tail.val;
    }

    public void put(int key, int value) {
        DeList node = null;
        if ((node = map.get(key)) != null) {
            node.val = value;
            moveNodeToTail(node);
        } else {
            if (map.size() == maxCap) {
                DeList temp = head.next;
                head.next = temp.next;
                if(temp.next!=null)
                    temp.next.pre = head;
                temp.pre = null;
                temp.next = null;
                if(tail==temp) tail=head;
                map.remove(temp.val);
            }
            tail.next = new DeList(value, tail, null);
            tail = tail.next;
            map.put(key,tail);
        }
    }

    private void moveNodeToTail(DeList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = node;
    }


    public static void main(String[] args) {
        Demo146_LRU lru = new Demo146_LRU(1);
        lru.put(2,2);
//        lru.put(2,2);
        lru.get(2);
        lru.put(3,3);
        lru.get(2);
//        lru.put(4,4);
        lru.get(3);
//        lru.get(3);
//        lru.get(4);

    }
}
