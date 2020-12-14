package algorithm.other;

import algorithm.ListNode;
import algorithm.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/12/5 - 12 - 05 - 19:55
 * @Description: 一个二叉树，仅包含0-9的数字，每一条从根节点到叶节点的路径都可以用一个数字表示，如1->2->3表示123，求所有路径表示的数字之和
 * @Version: 1.0
 */
public class FindAllSumInBiTree {

    //递归写法
    public List<Integer> findAllNum(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            int val = root.val;
            backTrack(root, val, list);
        }
        return list;
    }
    private void backTrack(TreeNode root, int val, List<Integer> list) {
        if(root.left==null&&root.right==null){
            list.add(val);
            return;
        }
        if(root.left!=null){
            backTrack(root.left, val*10+root.left.val, list);
        }
        if(root.right!=null){
            backTrack(root.right, val*10+root.right.val, list);
        }
    }

    @Test
    public void test(){
        TreeNode tree = TreeNode.getTestTree();
        List<Integer> list = findAllNum2(tree);
        System.out.println(list);
    }

    //非递归写法，基于后序遍历
    public List<Integer> findAllNum2(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = root;
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;
        if(p!=null) stack.push(p);
        while(!stack.isEmpty()){
            p = stack.peek();
            if(p.left!=null && p.left!=pre && p.right!=pre){
                stack.push(p.left);
            }else if(p.right!=null && pre!=p.right){
                stack.push(p.right);
            } else{
                if(p.left==null && p.right==null)
                    res.add(findNum(stack));
                stack.pop();
                pre = p;
            }
        }
        return res;
    }

    private Integer findNum(Deque<TreeNode> stack) {
        int num = 0;
        Deque<TreeNode> stack2 = new ArrayDeque<>(stack.size());
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            num = num *10 + node.val;
            stack2.push(node);
        }
        while(!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return num;
    }
}
