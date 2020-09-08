package leetcode;

import java.util.Arrays;

public class Demo16_10 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
//                    if (nums[j] == nums[j - 1] && j != i + 1) {
//                        j++;
//                        continue;
//                    }
//                    if (k != nums.length - 1 && nums[k] == nums[k + 1]) {
//                        k--;
//                        continue;
//                    }
                    int close = nums[i] + nums[j] + nums[k] - target;
                    if (Math.abs(close) < Math.abs(closest)) {
                        closest = close;
                    }
                    if (close > 0) {
                        k--;
                    } else if (close<0){
                        j++;
                    }else{
                        return target;
                    }
                }
            }
        }
        return target + closest;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new Demo16_10().threeSumClosest(input, 82));
    }
}
