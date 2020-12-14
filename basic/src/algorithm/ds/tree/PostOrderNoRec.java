package algorithm.ds.tree;

import algorithm.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 14:26
 * @Description: algorithm.ds.tree
 * @Version: 1.0
 */
public class PostOrderNoRec {
    /**
     * 基于先序遍历，需要再使用一个额外的辅助栈
     * @param root
     * @return
     */
    public List<TreeNode> postOrder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        if(root==null) return list;
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> tempStack = new ArrayDeque<>(); //辅助栈
        stack.push(p);        //根节点入栈
        while(!stack.isEmpty()){       //循环至栈空
            tempStack.push(p=stack.pop());    //弹栈，进入结果的辅助栈
            if(p.left!=null)    stack.push(p.left);     //左孩子入栈
            if(p.right!=null)   stack.push(p.right);    //右孩子入栈
        }
        while(!tempStack.isEmpty()){
            list.add(tempStack.pop());
        }
        return list;
    }

    /**
     * 基于中序遍历，无需再使用额外的辅助栈
     * @param root
     * @return
     */
    public List<TreeNode> postOrder2(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = root;
        if(p==null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left!=null && p!=temp.left && p!=temp.right){ //左右孩子均不是上次访问过的节点
                stack.push(temp.left); //左孩子入栈
            } else if(temp.right!=null && p!=temp.right){ //左孩子空了或访问了，右孩子不是上次访问过的节点，入栈
                stack.push(temp.right);
            } else{ //左右孩子都已经访问或空，可以访问这个节点了
                list.add(stack.pop());
                p = temp; //p记录上次访问的节点
            }
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
        List<TreeNode> list = postOrder2(node2);
        list.stream().forEach((x)->System.out.println(x.val));
    }


}
