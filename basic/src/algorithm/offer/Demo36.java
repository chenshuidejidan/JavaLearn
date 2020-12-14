package algorithm.offer;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 13:59
 * @Description: algorithm.offer
 * @Version: 1.0
 */

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Demo36 {
    public Node treeToDoublyList(Node root) {
        if(root==null)  return root;
        Deque<Node> stack = new ArrayDeque<>();
        Node p = root;
        Node pre = null;
        Node head = null;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                p.left = pre;
                if(pre!=null)   pre.right = p;
                else head=p;
                pre = p;
                System.out.println(p);
                p = p.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

}
