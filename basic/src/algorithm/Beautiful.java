package algorithm;

import java.util.Scanner;

/**
 * @Auther: c
 * @Date: 2021/3/28 - 03 - 28 - 20:12
 * @Description: algorithm
 * @Version: 1.0
 */
public class Beautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i]+nums[j]>nums[k] && nums[i]+nums[k]>nums[j] && nums[j]+nums[k]>nums[i]) {
                        int beauty = Math.abs(nums[i]-nums[j]) + Math.abs(nums[j]-nums[k]) + Math.abs(nums[i]-nums[k]);
                        if (beauty > max) max = beauty;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
