package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/8 - 12 - 08 - 14:44
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[2];    //i位置为结尾的最大和连续子数组
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i<nums.length; i++){
            dp[i%2] = Math.max(dp[(i+1)%2]+nums[i], nums[i]);
            if(dp[i%2]>max) max = dp[i%2];
        }
        return max;
    }

    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
