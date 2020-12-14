package algorithm.leetcode;

import algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/12/6 - 12 - 06 - 23:15
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==q) return p;
        if(root==null||p==null||q==null)    return null;
        Deque<TreeNode> stack1 = getStack(root, p);
        Deque<TreeNode> stack2 = getStack(root, q);
        while(stack1.size()>stack2.size()){
            stack1.pop();
        }
        while(stack2.size()>stack1.size()){
            stack2.pop();
        }
        TreeNode res = root;
        if(stack1.size()==0||stack2.size()==0)    return root;
        while((res = stack1.pop())!=stack2.pop());
        return res;
    }

    public Deque<TreeNode>  getStack(TreeNode root, TreeNode p){
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root!=null)  stack.push(root);
        TreeNode pre = root;
        TreeNode cur = root;
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left!=null && cur.left!=pre && cur.right!=pre)   stack.push(cur.left);
            else if(cur.right!=null && cur.right!=pre) stack.push(cur.right);
            else{
                pre = stack.pop();
                if(pre == p)
                    break;
            }
        }
        return stack;
    }

    //                 1
    //              /     \
    //            2         3
    //           / \       /
    //          4   5     6
    //               \     \
    //                7     8


    public static void main(String[] args) {
        TreeNode root = TreeNode.getTestTree();
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode node = new Demo236().lowestCommonAncestor(root, p, q);
        System.out.println(node.val);
    }
}
