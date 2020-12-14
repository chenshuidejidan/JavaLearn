package algorithm.leetcode;

import algorithm.TreeNode;
import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/7 - 12 - 07 - 14:36
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)  return 0;
        int leftSumCount = pathSum(root.left, sum);
        int rightSumCount = pathSum(root.right, sum);
        count = 0;
        dfs(root, sum);
        return leftSumCount+rightSumCount+count;
    }

    public int count = 0;
    public void dfs(TreeNode root, int sum){
        if(root==null)  return;
        sum -= root.val;
        if(sum==0){
            count++;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    @Test
    public void test(){

    }
}
