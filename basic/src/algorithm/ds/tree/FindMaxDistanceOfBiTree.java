package algorithm.ds.tree;

import algorithm.TreeNode;
import org.junit.Test;

import javax.sound.sampled.DataLine.Info;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 17:03
 * @Description: algorithm.ds.tree 找出一颗二叉树上所有两两节点间的最大距离
 * @Version: 1.0
 */
public class FindMaxDistanceOfBiTree {
    /**
     * 最大距离经过x节点：左子树高度+右子树高度
     * 最大距离不经过x节点：max(左子树最大距离， 右子树最大距离)
     */

    class Info{
        int maxLength;
        int height;

        public Info(int maxLength, int height) {
            this.maxLength = maxLength;
            this.height = height;
        }
    }

    public int findMaxDistanceOfBiTree(TreeNode root){
        return findMaxDistanceOfBiTree2(root).maxLength;
    }

    private Info findMaxDistanceOfBiTree2(TreeNode root) {
        if(root==null)  return new Info(0,0);
        Info leftInfo = findMaxDistanceOfBiTree2(root.left);
        Info rightInfo = findMaxDistanceOfBiTree2(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        int maxLength = Math.max(leftInfo.maxLength, Math.max(rightInfo.maxLength, leftInfo.height+rightInfo.height+1));
        return new Info(maxLength, height);
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
        System.out.println(findMaxDistanceOfBiTree(node1));
    }
}
