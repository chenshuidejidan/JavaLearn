package algorithm.offer;


import algorithm.ListNode;

public class Demo06 {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p!=null){
            count++;
            p = p.next;
        }
        int[] arr = new int[count];
        p = head;
        while(p!=null){
            arr[--count]=p.val;
            p = p.next;
        }
        return arr;
    }
}
