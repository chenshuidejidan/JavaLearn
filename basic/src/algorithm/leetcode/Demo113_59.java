package algorithm.leetcode;

import algorithm.TreeNode;
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
        TreeNode root = TreeNode.getTestTree();
        List<List<Integer>> list = pathSum2(root, 18);
        System.out.println(list);
    }


    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<Integer>());
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list){
        if(root==null)  return;
        list.add(root.val);
        sum-=root.val;
        if(root.left==null && root.right==null && sum==0){
            result.add(new ArrayList<>(list));
        }
        if(root.left!=null){
            dfs(root.left, sum, list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            dfs(root.right, sum, list);
            list.remove(list.size()-1);
        }
    }

    @Test
    public void testDfs(){
        TreeNode root = TreeNode.getTestTree();
        dfs(root, 18);
        System.out.println(count);
    }
    //计算总路径条数
    public int count = 0;
    public void dfs(TreeNode root, int sum){
        if(root==null)  return;
        sum -= root.val;
        if(root.left==null && root.right == null && sum==0){
            count++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

}
