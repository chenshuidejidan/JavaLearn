package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo113_59 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)  return result;
        List path = new ArrayList();
        path.add(root.val);
        backTrack(root, root.val, sum, path);
        return result;
    }

    public void backTrack(TreeNode root, int sumNow, int sum, List path){
        if(root.left==null && root.right==null){
            if(sumNow==sum)
                result.add(new ArrayList(path));
            return;
        }
        if(root.left!=null){
            path.add(root.left.val);
            backTrack(root.left, sumNow+root.left.val, sum, path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            path.add(root.right.val);
            backTrack(root.right, sumNow+root.right.val, sum, path);
            path.remove(path.size()-1);
        }
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2, node1, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3, node4, node5);
        TreeNode root = new TreeNode(1, node3, node6);
        List<List<Integer>> list = pathSum(root, 6);
        System.out.println(list);
    }
}
