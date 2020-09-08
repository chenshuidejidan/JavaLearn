package leetcode;

import java.util.Arrays;

public class Demo34_20 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)  return new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        //找左侧边界
        while(left<=right){
            int mid = left + (right - left)/2;
            if(target>nums[mid]){
                left = mid+1;
            }else{  //收紧右边界
                right = mid-1;
            }
        }
        int left_bound = -1;
        if(left<nums.length&&nums[left]==target){   //检查出界
            left_bound = left;
        } else{
            return new int[]{-1,-1};
        }
        right = nums.length-1;
        //找右侧边界
        while(left<=right){
            int mid = left + (right - left)/2;
            if(target>=nums[mid]){  //收紧左边界
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        int right_bound = -1;
        if(nums[left-1]==target)    right_bound = left-1;
        return new int[]{left_bound, right_bound};
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        System.out.println(Arrays.toString(new Demo34_20().searchRange(nums, target)));
    }
}
