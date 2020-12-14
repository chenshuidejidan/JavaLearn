package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2020/12/5 - 12 - 05 - 10:36
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class LRUCache {
    private class DeList {
        public DeList pre;
        public DeList next;
        public int key;
        public int value;

        public DeList(int key, int value, DeList pre, DeList next) {
            this.pre = pre;
            this.next = next;
            this.value = value;
            this.key = key;
        }
        public DeList(){}
    }

    private int maxCap;
    private Map<Integer, DeList> map;
    private DeList head = new DeList(-1, -1, null, null);
    private DeList tail = head;

    public LRUCache(int capacity) {
        this.maxCap = capacity;
        this.map = new HashMap<>(capacity);
    }



    public int get(int key) {
        DeList node = null;
        if ((node = map.get(key)) == null) return -1;
        moveNodeToHeadNext(node);
        return node.value;
    }

    public void put(int key, int value) {
        DeList insertNode = null;
        if ((insertNode = map.get(key)) != null) {
            insertNode.value = value;
            moveNodeToHeadNext(insertNode);
        } else {    //原来LRU中不存在这个键值对
            insertNode = new DeList(key, value, null, null);
            if(map.size()==maxCap){
                DeList last = deleteLast();
                if(last!=null)
                    map.remove(last.key);
                moveNodeToHeadNext(insertNode);
            } else {
                if(head==tail){
                    head.next = insertNode;
                    insertNode.pre = head;
                    tail = insertNode;
                }else{
                    moveNodeToHeadNext(insertNode);
                }
            }
            map.put(key, insertNode);
        }
    }

    private void moveNodeToHeadNext(DeList node){
        if(node!=head.next){
            if(node==tail)  tail = node.pre;
            DeList oriHeadNext = head.next;
            if(node.pre!=null)  node.pre.next = node.next;
            if(node.next!=null) node.next.pre = node.pre;
            head.next = node;
            node.pre = head;
            node.next = oriHeadNext;
            if(oriHeadNext!=null) oriHeadNext.pre = node;
        }
    }

    private DeList deleteLast(){
        if(tail!=head){
            DeList last = tail;
            tail = tail.pre;
            tail.next = null;
            last.pre = null;
            return last;
        }
        return null;
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);

    }
}
