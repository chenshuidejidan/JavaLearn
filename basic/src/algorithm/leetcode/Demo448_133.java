package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2021/4/15 - 04 - 15 - 10:38
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo448_133 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new Demo448_133().findDisappearedNumbers(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){   //nums[i]=i+1
            if(nums[i]!=i+1){
                int times = nums.length;
                while(times-->0 && nums[i] != i+1 && nums[i]!=nums[nums[i]-1])
                    swap(nums, i, nums[i]-1);
            }
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != i+1)
                res.add(i+1);
        return res;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
