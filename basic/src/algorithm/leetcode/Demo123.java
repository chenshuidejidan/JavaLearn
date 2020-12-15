package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 16:42
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo123 {
    public int maxProfit(int[] prices) {
        //两次买入两次卖出
        int min = prices[0];
        int[] profit1 = new int[prices.length]; //第i天第一次卖出的最大利润
        for(int i = 0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            profit1[i] = prices[i]-min;
        }

        int max = 0;
        int res = profit1[prices.length-1];
        int profit2 = 0;

        for(int j = prices.length-1; j>0; j--){
            max = Math.max(max, prices[j]);
            profit2 = Math.max(profit2, max-prices[j]);  //第j天第二次买入的最大利润
            res = Math.max(res, profit1[j-1] + profit2);
        }
        return res;
    }

    @Test
    public void test(){
        int[] prices = {1,100,50,3,7};
        System.out.println(maxProfit(prices));
    }
}
