package algorithm.leetcode;

import java.util.Arrays;

public class Demo322 {
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] < dp[i])
                        dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0||amount==0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    if (dp[i - coin] != -1 && (dp[i] == -1 || dp[i - coin] < dp[i]))
                        dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(new Demo322().coinChange(coins, amount));
    }
}
