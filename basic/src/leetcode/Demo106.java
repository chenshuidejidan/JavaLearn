package leetcode;

import org.junit.Test;

public class Demo106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0) return null;
        else return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if(il>ir||pl>pr)    return null;
        int index = 0;
        for(index=0; index<inorder.length-1 && inorder[index]!=postorder[pr]; index++);
        int leftCount = index-il;

        TreeNode root = new TreeNode(inorder[index]);
        root.left = buildTree(inorder, il, index-1, postorder, pl, pl+leftCount-1);
        root.right = buildTree(inorder, index+1, ir, postorder, pl+leftCount, pr-1);

        return root;
    }

    @Test
    public void testBuildTree() {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }
}
