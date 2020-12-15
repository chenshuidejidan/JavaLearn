package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 17:54
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo188 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int n = prices.length;  //天数
        //完成交易i
        int[][] dp = new int[k+1][2]; //状态0卖出，状态1买入
        int res = 0;
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第j次买入，完成交易j-1次
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第j次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);

            }
        }
        return dp[k][0];
    }
}
