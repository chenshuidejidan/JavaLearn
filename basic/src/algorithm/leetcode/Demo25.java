package algorithm.leetcode;

import algorithm.ListNode;
import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/8 - 12 - 08 - 16:29
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo25 {
    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = reverseKGroup(node1, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)    return head;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;     //当前k个节点的伪头节点
        ListNode post = getPost(pre, k);    //当前k个节点的最后一个节点
        ListNode nextHead = post.next;       //下一个k个节点的第一个节点
        while(post!=null){
            pre.next = reverse(pre, nextHead);
            pre = getPost(pre, k);
            post = getPost(pre, k);
            if(post!=null)  nextHead = post.next;
        }
        return fakeHead.next;
    }

    private ListNode getPost(ListNode pre, int k){
        while(k>0){
            if(pre == null) return null;
            pre = pre.next;
            k--;
        }
        return pre;
    }

    private ListNode reverse(ListNode fakeHead, ListNode nextHead){
        ListNode p = fakeHead.next;
        ListNode pnext = p.next;
        ListNode tail = fakeHead.next;
        fakeHead.next = null;
        while(p!=nextHead){
            ListNode temp = fakeHead.next;
            fakeHead.next = p;
            p.next = temp;
            p = pnext;
            if(pnext!=null) pnext = pnext.next;
        }
        tail.next = nextHead;
        return fakeHead.next;
    }
}
