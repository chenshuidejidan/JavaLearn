package leetcode;

import org.junit.Test;

import java.util.HashMap;

public class Demo109_59 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if(head==tail)  return null;
        ListNode mid = getMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head, mid);
        root.right = sortedListToBST(mid.next, tail);
        return root;
    }

    private ListNode getMid(ListNode head, ListNode tail) {
        ListNode p = head;
        ListNode mid = head;
        while(p!=tail){
            p = p.next;
            if(p!=tail){
                p = p.next;
                mid = mid.next;
            }
        }
        return mid;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        TreeNode root = sortedListToBST(node1);
        System.out.println(root);
    }
}
