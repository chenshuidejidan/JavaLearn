package algorithm.offer;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/7 - 12 - 07 - 17:52
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo300 {
    public int lengthOfLIS(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length][2];
        //dp[i][j][0]是从i到j的最长上升子序列的长度，dp[i][j][1]是这个最长上升子序列的最后一个数的index
        for(int i = 0; i<nums.length; i++){
            dp[i][i][0] = 1;
            dp[i][i][1] = i;
        }

        for(int len = 1; len<nums.length; len++){
            for(int i = 0; i+len<nums.length; i++){
                if(nums[i+len]>nums[dp[i][i+len-1][1]]){
                    dp[i][i+len][0] = dp[i][i+len-1][0]+1;
                    dp[i][i+len][1] = i+len;
                } else {
                    dp[i][i+len][0] = dp[i][i+len-1][0];
                    dp[i][i+len][1] = dp[i][i+len-1][1];
                }
            }
        }
        return dp[0][nums.length-1][0];
    }

    @Test
    public void test(){
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
