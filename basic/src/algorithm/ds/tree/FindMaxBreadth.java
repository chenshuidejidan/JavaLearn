package algorithm.ds.tree;

import algorithm.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 15:35
 * @Description: algorithm.ds.tree 求树的最大宽度
 * @Version: 1.0
 */
public class FindMaxBreadth {
    /**
     * 找到最大宽度
     * @param root
     * @return
     */
    public int findMaxBreadth(TreeNode root){
        if(root==null)  return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curEnd=root;   //当前层的最右节点
        TreeNode nextEnd = null;    //下一层的最右节点
        int maxBreadth=1;
        int curBreadeh = 0; //当前层的宽度
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            curBreadeh++;
            if(p.left!=null){
                queue.offer(p.left);
                nextEnd=p.left;
            }
            if(p.right!=null){
                queue.offer(p.right);
                nextEnd = p.right;
            }
            if(p==curEnd){
                curEnd = nextEnd;
                maxBreadth = Math.max(maxBreadth, curBreadeh);
                curBreadeh=0;
            }
        }
        return maxBreadth;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;        //         1
        node3.left = node5;         //     2       3
        node2.left = node4;         //   4       5
        node1.left = node2;         //            6
        node1.right = node3;        //
        System.out.println(findMaxBreadth(node1));
    }

}
