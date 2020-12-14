package algorithm.leetcode;

import algorithm.ListNode;
import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/8 - 12 - 08 - 21:11
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo445 {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l2.next = l3;
        ListNode sum = addTwoNumbers(l1, l2);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        if(len2>len1){
            ListNode temp = l1;
            int tempLen = len1;
            l1 = l2;
            l2 = temp;
            len1 = len2;
            len2 = tempLen;
        }
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for(int i = 0; i < len1-len2; i++){
            p.next = new ListNode(p1.val);
            p = p.next;
            p1 = p1.next;
        }
        while(p1!=null&&p2!=null){
            p.next = new ListNode(p1.val+p2.val);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(head);
        p = head.next;
        int add = 0;
        while(p!=null){
            if((p.val=p.val+add)>=10){
                p.val-=10;
                add=1;
            }else
                add = 0;
            if(p.next==null && add==1){
                p.next = new ListNode(1);
                break;
            }
            p = p.next;
        }
        reverseList(head);
        return head.next;

    }

    private int len(ListNode head){
        int length = 0;
        while(head!=null){
            head = head.next;
            length++;
        }
        return length;
    }

    private void reverseList(ListNode head){
        ListNode p = head.next;
        ListNode pnext = head.next;
        head.next = null;
        while(p!=null){
            if(pnext!=null) pnext = pnext.next;
            ListNode temp = head.next;
            head.next = p;
            p.next = temp;
            p = pnext;
        }
    }
}
