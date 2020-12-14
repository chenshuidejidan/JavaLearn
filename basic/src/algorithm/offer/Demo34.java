package algorithm.offer;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 13:01
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo34 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)  return res;
        List<Integer> list = new ArrayList<>();
        backTrack(root, sum, list);
        return res;
    }

    public void backTrack(TreeNode root, int sum, List<Integer> list){
        list.add(root.val);
        sum-=root.val;
        if(root.left==null&&root.right==null){
            if(sum==0)  res.add(new ArrayList(list));
            return;
        }
        backTrack(root.left, sum, list);
        list.remove(list.size()-1);
        backTrack(root.right, sum, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {

    }
}
