package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2021/4/15 - 04 - 15 - 10:01
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo416_132 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if((sum & 1) == 1) return false;
        sum >>= 1;

        boolean[][] dp = new boolean[nums.length+1][sum+1];   //前面n个数，是否可以使得组合成和为sum
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j <= sum; j++){
                if(nums[i]==j)  dp[i][j] = true;
                else if(j-nums[i] > 0)  dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                else dp[i][j] = dp[i-1][j];
            }
            if (dp[i][sum]==true)   return true;
        }
        return false;
    }

}
