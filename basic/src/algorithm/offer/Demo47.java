package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 13:26
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo47 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int k = 1; k<grid.length; k++){ //行列和
            for(int i = 0; i<grid.length; i++){
                if(k-i<0)   continue;
                if(i==0)    dp[i][k-i]=dp[i][k-i-1]+grid[i][k-i];
                else if(k-i==0) dp[i][k-i]=dp[i-1][k-i]+grid[i][k-i];
                else dp[i][k-i] = Math.max(dp[i-1][k-i],dp[i][k-i-1]);
            }
        }
        for(int k = grid.length-1; k>=0; k--){
            for(int i = 0; i<grid.length; i++){
                if(k-i<0)   continue;
                dp[i][k-i] = Math.max(dp[i-1][k-i],dp[i][k-i-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
