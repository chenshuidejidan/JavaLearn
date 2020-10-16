package leetcode;

import org.junit.Test;

public class Demo105_57 {
    public TreeNode buildTree(int[] preorder, int[] inorder) throws Exception {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0)   return null;
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) throws Exception {
        if(pl>pr) return null;
        int index = 0;
        for(index=il; index<=ir&&inorder[index]!=preorder[pl]; index++);
        if(index>ir) throw new Exception();
        TreeNode root = new TreeNode(inorder[index]);
        int leftCount = index-il;

        root.left = buildTree(preorder, pl+1, pl+leftCount, inorder, il, index-1);
        root.right = buildTree(preorder, pl+leftCount+1, pr, inorder, index+1, ir);

        return root;
    }

    @Test
    public void testBuildTree() throws Exception {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }



}
