package algorithm;

import java.util.Scanner;

/**
 * @Auther: c
 * @Date: 2021/3/28 - 03 - 28 - 19:30
 * @Description: algorithm
 * @Version: 1.0
 */
public class DajiaJIeshe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] strings = s1.split("\\s+");
        int size = strings.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(new DajiaJIeshe().myMax(nums));
    }

    public int myMax(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }
}
