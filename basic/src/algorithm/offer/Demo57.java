package algorithm.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 11:27
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo57 {
    public int[][] findContinuousSequence(int target) {
        if(target<3)    return new int[0][0];
        int sum = 1;
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 2;
        while(left<right && right<target){
            while(sum<target)
                sum+=(right++);
            while(sum>target)
                sum-=(left++);
            if(sum==target){
                int[] arr = new int[right-left];
                for(int i = left; i<right; i++)    arr[i-left]=i;
                res.add(arr);
                sum+=(right++);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test(){
        int[][] ints = findContinuousSequence(9);
        System.out.println(Arrays.deepToString(ints));
    }
}
