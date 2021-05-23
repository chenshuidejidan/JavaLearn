package algorithm;

import test.Test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: c
 * @Date: 2021/3/28 - 03 - 28 - 18:59
 * @Description: algorithm
 * @Version: 1.0
 */
public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
        }
        System.out.println(new Temp().maxInterviews(n, times));
    }

    public int maxInterviews(int n, int[][] times) {
        Arrays.sort(times, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        boolean[] used = new boolean[n];
        used[1] = true;
        int j = 0;
        int count = 1;
        for (int i = 2; i< n; i++) {
            if(times[i][0]>=times[j][1]){
                used[i] = true;
                j = i;
                count++;
            }
            else used[i]=false;
        }
        return count;
    }
}
