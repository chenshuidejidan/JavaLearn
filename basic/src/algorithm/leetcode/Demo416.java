package algorithm.leetcode;

public class Demo416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        if(sum%2!=0)
            return false;
        sum/=2;

        //前面的i个数，是否可以组合成sum
        boolean[][] dp = new boolean[nums.length+1][sum+1];

        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<=sum; j++){
                if(nums[i-1]==j){
                    dp[i][j]=true;
                }
                else if(j-nums[i-1]>=0)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];

            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        int[] input = {1,2,5};
        System.out.println(new Demo416().canPartition(input));
    }
}

