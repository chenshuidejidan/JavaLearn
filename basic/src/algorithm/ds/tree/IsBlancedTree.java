package algorithm.ds.tree;

import algorithm.TreeNode;

/**
 * @Auther: c
 * @Date: 2020/11/20 - 11 - 20 - 16:48
 * @Description: algorithm.ds.tree
 * @Version: 1.0
 */
public class IsBlancedTree {
    class Info{ //需要的全部信息
        boolean isBalanced;
        int height;
        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalancedTree(TreeNode root){
        return isBlancedTree2(root).isBalanced;
    }

    public Info isBlancedTree2(TreeNode root){  //所有节点都返回需要的信息
        if(root == null)    return new Info(true, 0);
        Info leftInfo = isBlancedTree2(root.left);  //左右子树都可以返回需要的信息
        Info rightInfo = isBlancedTree2(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        boolean isBalanced = true;
        if(!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height-rightInfo.height)>1){
            isBalanced = false;
        }
        return new Info(isBalanced, height);    //按规定的要求返回
    }
}
