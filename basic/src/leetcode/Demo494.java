package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Demo494 {
    private int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0)
            return 0;
        int length = nums.length;
        char[] symbol = new char[length];
        backtrack(0, 0, nums, S);
        return result;
    }

    private void backtrack(int sum, int count, int[] nums, int s) {
        //检查，出口
        if (count == nums.length) {

            if (sum == s)
                result++;
            return;
        }

        sum+=nums[count];
        backtrack(sum, count + 1, nums, s);
        sum-=nums[count];

        sum-=nums[count];
        backtrack(sum, count + 1, nums, s);
    }

    public static void main(String[] args) {
        int[] nums = {11,20,19,3,25,7,30,45,8,11,35,19,29,9,49,14,22,34,12,0};
        int s = 34;
        System.out.println(new Demo494().findTargetSumWays(nums, s));

    }
}
