package algorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: c
 * @Date: 2021/3/28 - 03 - 28 - 20:02
 * @Description: algorithm
 * @Version: 1.0
 */
public class disiti {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        HashMap<Point, Integer> map = new HashMap<>();
        long[][] dp = new long[2][2];
        for (int i = 0; i<q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.put(new Point(x,y) ,1);
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (map.containsKey(new Point(i,j))){
                    dp[i&1][j&1] = 0;
                    continue;
                }
                if (i == 1 && j == 1) dp[i&1][j&1] = 1;
                else dp[i&1][j&1] = (dp[(i-1)&1][j&1]+ dp[i&1][(j-1)&1])%1000000000;
            }
        }
        System.out.println(dp[n&1][m&1]);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}