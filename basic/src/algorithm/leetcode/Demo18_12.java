package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo18_12 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int a = 0; a <= nums.length - 3; a++) {
            if (a != 0 && nums[a] == nums[a - 1])
                continue;
            for (int d = nums.length - 1; d >= a + 3; d--) {
                if (d != nums.length - 1 && nums[d] == nums[d + 1])
                    continue;
                int b = a + 1;
                int c = d - 1;
                if (nums[a] + nums[b] + nums[b+1]+nums[d]>target)
                    continue;   //需要减小d
                if(nums[a]+nums[c-1]+nums[c]+nums[d]<target)
                    break;  //需要增大a，直接跳到外层循环
                while (b < c) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target || (b != a + 1 && nums[b] == nums[b - 1])) {
                        b++;
                        continue;
                    }
                    if (nums[a] + nums[b] + nums[c] + nums[d] > target || (c != d - 1 && nums[c] == nums[c + 1])) {
                        c--;
                        continue;
                    }
                    if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        result.add(list);
                        b++;
                        c--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Demo18_12().fourSum(nums, target));
    }
}
