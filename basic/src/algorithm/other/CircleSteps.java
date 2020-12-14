package algorithm.other;

/**
 * @Auther: c
 * @Date: 2020/12/5 - 12 - 05 - 15:21
 * @Description: 环上10个点，从0出发，可以顺时针或逆时针走，n步之后又回到0点的走法有多少种
 * @Version: 1.0
 */
public class CircleSteps {
    public int getSteps(int steps){
        int[][] dp = new int[10][steps+1]; //到达点经过..步的方法数
        dp[0][0]=1;
        dp[1][1]=1;
        dp[1][9]=1;
        for(int step = 2; step<=steps; step++){
            for(int position = 0; position<10; position++){
                dp[position][step] = dp[(position+10-1)%10][step-1]+dp[(position+1)%10][step-1];
            }
        }
        return dp[0][steps];
    }

    public static void main(String[] args) {
        new CircleSteps().getSteps(10);
    }

}
