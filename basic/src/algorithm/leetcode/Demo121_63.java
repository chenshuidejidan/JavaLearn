package algorithm.leetcode;

import org.junit.Test;

public class Demo121_63 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)   return 0;
        int i = 0;
        while(i<prices.length-1 && prices[i]>=prices[i+1])    i++;
        if(i>=prices.length-1)    return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            int min2 = prices[i];

            while(i<prices.length-1&& prices[i]<=prices[i+1])
                i++;
            int max2 = prices[i];

            if(max==0||min2<=min && max2-min2>max-min){
                max=max2;
                min=min2;
            } else if(min2>min){
                max=Math.max(max2,max);
            }
        }
        return max-min;
    }


    @Test
    public void test(){

        int[] prices = {4,3,2,1,1,2,2,3,4,4,3,2,7,1,7,2,8,9,8,100,1};

        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
