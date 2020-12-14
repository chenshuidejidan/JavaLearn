package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo15_9 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        //第一个数
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                //第二、三个数
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k && nums[k] >= 0) {
                    if (j < k && nums[j] + nums[k] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    }
                    while (j < k && (j != i + 1 && nums[j] == nums[j - 1] || nums[j] + nums[k] < target))
                        j++;
                    while (j < k && (k != nums.length - 1 && nums[k] == nums[k + 1] || nums[j] + nums[k] > target))
                        k--;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(new Demo15_9().threeSum(input));
    }
}
