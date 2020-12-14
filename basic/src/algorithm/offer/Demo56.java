package algorithm.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: c
 * @Date: 2020/11/30 - 11 - 30 - 12:27
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo56 {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp^=nums[i];
        }
        int divided = 0;
        while(temp>0&&temp%2==0){
            temp>>=1;
            divided+=1;
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]>>divided)%2==0)  res[0]^=nums[i];
            else res[1]^=nums[i];
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1,2,5,2};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
