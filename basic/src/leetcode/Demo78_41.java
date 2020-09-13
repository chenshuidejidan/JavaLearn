package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Demo78_41 {
    //回溯法
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums==null||nums.length==0)   return result;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int current, List<Integer> list) {
        result.add(new ArrayList<>(list));
        if(list.size()==nums.length)  return;
        for(int i = current; i<nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

    //掩码法
    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0; i<Math.pow(2, nums.length); i++){
            List<Integer> list = new ArrayList<>();
            int iCopy = i;
            for(int j=0; j<nums.length&&i>0; j++){
                if(iCopy%2==1)  list.add(nums[j]);
                iCopy>>=1;
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new Demo78_41().subsets(nums);
        System.out.println(subsets);
    }
}
