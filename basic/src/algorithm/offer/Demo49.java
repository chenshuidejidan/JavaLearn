package algorithm.offer;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/7 - 12 - 07 - 17:09
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo49 {
    public int nthUglyNumber(int n) {
        if(n<=6)    return n;
        int[] dp = new int[n+1];
        for(int i = 1; i<=6; i++)   dp[i] = i;
        int a = 1, b=1, c=1;
        for(int i = 7; i<=n; i++){
            while(2*dp[a]<=dp[i-1]||3*dp[b]<=dp[n-1]||5*dp[c]<=dp[n-1]){
                if(dp[a]<=dp[i-1])  a++;
                if(dp[b]<=dp[i-1])  b++;
                if(dp[c]<=dp[i-1])  c++;
            }
            dp[i] = Math.min(Math.min(2*dp[a], 3*dp[b]),5*dp[c]);
        }
        return dp[n];
    }

    @Test
    public void test(){

    }
}
