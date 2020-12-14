package algorithm.leetcode;

import java.util.Arrays;

public class Demo62 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0);
        Arrays.fill(dp[1], 1);
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 2; i < m + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int i = new Demo62().uniquePaths(m, n);
        System.out.println(i);
    }
}
