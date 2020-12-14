package algorithm.offer;

import algorithm.TreeNode;

public class Demo07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if(il>ir||pl>pr)    return null;
        for(int i = il; i<=ir; i++){
            if (inorder[i]==preorder[pl]){
                TreeNode root = new TreeNode(preorder[pl]);
                int leftCount = i - il;
                root.left = buildTree(preorder, pl+1, pl+leftCount, inorder, il, i-1);
                root.right = buildTree(preorder, pl+1+leftCount, pr, inorder, i+1, ir);
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new Demo07().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
