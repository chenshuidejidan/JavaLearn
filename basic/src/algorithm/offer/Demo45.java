package algorithm.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 10:42
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo45 {
    public String minNumber(int[] nums) {
        Integer[] nums2 = new Integer[nums.length];
        int j = 0;
        for(int num : nums)  nums2[j++]=num;
        Arrays.sort(nums2, (o1, o2)->{
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s1+s2).compareTo(s2+s1);
        });

        StringBuilder sb = new StringBuilder();
        for(int num: nums2){
            sb.append(num);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        int[] nums = {128,12};
        String s = minNumber(nums);
        System.out.println(s);
    }

}
