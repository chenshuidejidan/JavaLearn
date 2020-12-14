package algorithm.leetcode;

import algorithm.ListNode;

public class Demo82_43 {    //好难啊！！！！！！
    //自己写的非递归，难
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)  return head;
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        ListNode pre = newHead;
        ListNode last = newHead;
        ListNode p = head;
        while(p!=null){
            if(p.val==last.val){
                while(p!=null && p.val==last.val)  p=p.next;
                pre.next = p;
                last = p;
            }else{
                last.next = p;
                pre = last;
                last = p;
            }
            if(p!=null) p = p.next;
        }
        return newHead.next;
    }

    //递归写法~~~~~~
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(3);
        ListNode h5 = new ListNode(4);
        ListNode h6 = new ListNode(5);
        head.next = h2;
        h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next=h6;
        h6.next=null;
        new Demo82_43().deleteDuplicates2(head);
        while(head!=null){
            System.out.print(head.val+"--->");
            head = head.next;
        }
    }
}
