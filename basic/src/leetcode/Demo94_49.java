package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class Demo94_49 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty()||p!=null) {
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        node3.left = node1;
        List<Integer> integers = new Demo94_49().inorderTraversal(node2);
        System.out.println(integers);

    }
}
