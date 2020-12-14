package algorithm.ds.tree;

import algorithm.TreeNode;
import algorithm.leetcode.Demo94_49;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 13:45
 * @Description: algorithm.ds.tree,非递归的先序遍历
 * @Version: 1.0
 */
public class PreOrderNoRec {
    public List<TreeNode> preOrder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        if(root==null) return list;
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);        //根节点入栈
        while(!stack.isEmpty()){       //循环至栈空
            list.add(p=stack.pop());    //弹栈访问
            if(p.right!=null)   stack.push(p.right);    //右孩子入栈
            if(p.left!=null)    stack.push(p.left);     //左孩子入栈
        }
        return list;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        node3.right = node1;
        List<TreeNode> list = preOrder(node2);
        list.stream().forEach((x)->System.out.println(x.val));
    }
}
