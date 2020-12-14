package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @Auther: c
 * @Date: 2020/12/3 - 12 - 03 - 15:04
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo496 {
    public int[] nextGreaterElement(int[] nums) {
        if(nums==null||nums.length==0)  return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        for(int i = 2*nums.length-1; i>=0; i--){
             while(!stack.isEmpty()&&stack.peek()<=nums[i%nums.length]){
                 stack.pop();
             }
             res[i%nums.length] = stack.isEmpty()?-1:stack.peek();
             stack.push(nums[i%nums.length]);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement(nums1);
        System.out.println(Arrays.toString(ints));
    }
}
