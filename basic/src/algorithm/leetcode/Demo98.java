package algorithm.leetcode;

import algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/12/7 - 12 - 07 - 20:21
 * @Description: algorithm.leetcode 验证二叉搜索树
 * @Version: 1.0
 */
public class Demo98 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode pre = null;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                if(pre!=null&&pre.val>=p.val) return false;
                pre = p;
                p = p.right;
            }
        }
        return true;
    }



    //递归写法，没有很好的理解
    // private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
    //     if(root==null)   return true;
    //     if(lower!=null && root.val<=lower) return false;
    //     if(upper!=null && root.val>=upper) return false;
    //     if(!isValidBST(root.left, lower, root.val)) return false;
    //     if(!isValidBST(root.right, root.val, upper)) return false;
    //     return true;
    // }
}
