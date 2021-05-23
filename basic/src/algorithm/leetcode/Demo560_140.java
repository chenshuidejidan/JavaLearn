package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2021/4/21 - 04 - 21 - 21:58
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo560_140 {
    public int subarraySum(int[] nums, int k) {
        //dp[i][j] = dp[i][j-1]+nums[j]
        int[][] dp = new int[nums.length][nums.length];
        int res = 0;
        for(int incr = 0; incr < nums.length; incr++){
            for(int i = 0; i+incr < nums.length; i++){
                dp[i][i+incr] = (incr==0?0:dp[i][i+incr-1])+nums[i+incr];
                if(dp[i][i+incr]==k)    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 0;
        System.out.println(new Demo560_140().subarraySum(nums, k));
    }
}
