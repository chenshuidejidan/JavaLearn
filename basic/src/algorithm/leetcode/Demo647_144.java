package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2021/5/23 - 05 - 23 - 13:24
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo647_144 {
    public int countSubstrings(String s) {
        int cnt = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int start = 0; i + start < s.length(); start++) {
                if (i == 0 || s.charAt(start) == s.charAt(start + i) && (start + 1 >= start + i - 1 || dp[start + 1][start + i - 1] == 1)) {
                    dp[start][start + i] = 1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
