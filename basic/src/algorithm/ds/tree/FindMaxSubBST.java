package algorithm.ds.tree;


import algorithm.TreeNode;
import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 22:54
 * @Description: algorithm.ds.tree 查找一棵树的最大二叉搜索子树
 * @Version: 1.0
 */
public class FindMaxSubBST {
    class Info{
        public boolean isBST;
        public TreeNode maxSubBST;
        public int maxSubBSTSize;
        public int max;
        public int min;
        public Info(boolean isBST, TreeNode maxSubBST, int maxSubBSTSize, int max, int min) {
            this.isBST = isBST;
            this.maxSubBST = maxSubBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    public Info maxSubBST(TreeNode root){
        if(root == null) return null;

        Info leftInfo = maxSubBST(root.left);
        Info rightInfo = maxSubBST(root.right);

        boolean isBST = false;
        TreeNode maxSubBST = null;
        int maxSubBSTSize=0;
        int max = root.val;
        int min = root.val;

        if(leftInfo!=null){     //先把max和min确定下来，比较好确定
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
        }
        if(rightInfo!=null){
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
        }

        if((leftInfo==null||(leftInfo.isBST && leftInfo.max<root.val))   &&
                (rightInfo==null||(rightInfo.isBST && rightInfo.min>root.val))){  //root本身是二叉搜索树
            isBST = true;
            maxSubBSTSize = (leftInfo==null?0:leftInfo.maxSubBSTSize) + (rightInfo==null?0: rightInfo.maxSubBSTSize) +1;
            maxSubBST = root;
        } else {    //左右孩子至少有一个非空，分别处理
            if(leftInfo!=null){ //更新为左子树的最大BST
                maxSubBSTSize = leftInfo.maxSubBSTSize;
                maxSubBST = leftInfo.maxSubBST;
            }
            if(rightInfo!=null && rightInfo.maxSubBSTSize>maxSubBSTSize){ //判断是否要更新为右子树的最大BST
                maxSubBSTSize = rightInfo.maxSubBSTSize;
                maxSubBST = rightInfo.maxSubBST;
            }
        }
        return new Info(isBST, maxSubBST, maxSubBSTSize, max, min);
    }

    public TreeNode findMaxSubBST(TreeNode root){
        return maxSubBST(root).maxSubBST;
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
        TreeNode root = findMaxSubBST(node1);
        System.out.println(root);
    }

}
