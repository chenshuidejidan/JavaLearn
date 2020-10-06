package leetcode;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Demo92_48 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;  //m的前一个节点
        ListNode temp;
        int i = 0;
        for(i = 1; i<m; i++){
            if(pre.next!=null)    pre = pre.next;
            else return head;
        }
        head = pre.next;    //记录m节点
        for(i = m+1; i<=n; i++){
            if(head.next!=null){
                temp = head.next;
                head.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = new Demo92_48().reverseBetween(n1, 2, 4);
        while(listNode!=null){
            System.out.print(listNode.val+"--->");
            listNode = listNode.next;
        }
    }
}
