package algorithm.leetcode;

import org.junit.Test;

public class Demo137_67 {
    public int singleNumber(int[] nums) {
        int a = 0, b=0;
        for(int num:nums){
            a=b&(a^num);
            b=a|~a&(b^num);
        }
        return b;
    }



    @Test
    public void test(){
        int[] nums = {-2,-2,-3,-2};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}
