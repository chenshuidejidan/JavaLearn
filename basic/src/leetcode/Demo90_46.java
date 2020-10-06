package leetcode;

import java.util.*;

public class Demo90_46 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int curor, ArrayList<Integer> list) {
        result.add(new ArrayList<>(list));
        for(int i = curor; i<nums.length; i++){
            if(i>curor && nums[i]==nums[i-1])    //只需要保证在每一轮中没有重复的使用同一个数字即可
                continue;   //而不同轮中，作为开始的curor，依然可以被使用
            list.add(nums[i]);
            backtrack(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

//    private Set<List<Integer>> set = new HashSet<>();
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        backtrack(nums, 0, new ArrayList<>());
//        return new ArrayList<List<Integer>>(set);
//    }
//    void backtrack(int[] nums, int curor, List<Integer> list){
//        set.add(new ArrayList<Integer>(list));
//        for(int i = curor; i< nums.length; i++){
//            list.add(nums[i]);
//            backtrack(nums, i+1, list);
//            list.remove(list.size()-1);
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = new Demo90_46().subsetsWithDup(nums);
        System.out.println(lists);
    }
}
