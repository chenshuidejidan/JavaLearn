package leetcode;

import org.junit.Test;

public class Demo108_58 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)  return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right)  return null;

        int mid = (left+right)>>1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, right);
        return root;
    }

    private void inOrder(TreeNode root){
        if(root==null)  return;
        if(root.left!=null) inOrder(root.left);
        System.out.println(root.val);
        if(root.right!=null) inOrder(root.right);
    }

    @Test
    public void test(){
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        inOrder(root);
    }
}
