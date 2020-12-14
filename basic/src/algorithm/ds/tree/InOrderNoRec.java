package algorithm.ds.tree;

import algorithm.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 13:45
 * @Description: algorithm.ds.tree, 非递归的先序遍历
 * @Version: 1.0
 */
public class InOrderNoRec {
    public List<TreeNode> inOrder(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty()||p!=null) {
            if(p!=null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                list.add(p);
                p = p.right;    //注意此处一定不要加if(p!=null)，否则会来回入栈，p为null正好是弹栈了
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
        List<TreeNode> list = inOrder(node2);
        list.stream().forEach((x)->System.out.println(x.val));
    }
}
