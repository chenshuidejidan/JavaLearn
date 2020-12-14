package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther: c
 * @Date: 2020/12/8 - 12 - 08 - 10:08
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo239 {

    @Test
    public void test(){
        int[] nums  = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow2(nums, 3);
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int resIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) deque.pollLast();
            deque.offerLast(i);
            if(deque.peekFirst()<i-k+1) deque.pollFirst();
            if(i>=k-1)  res[resIndex++] = deque.peekFirst();
        }
        return res;
    }



    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        for(i = 0; i<k && i<nums.length; i++){
            myoffer(deque, nums[i]);
        }
        if(i==0)    return new int[0];
        if(i==nums.length)  return new int[]{deque.peekFirst()};
        int[] res = new int[nums.length-k+1];
        res[0] = deque.peekFirst();
        for(i = k; i<nums.length; i++){
            mypoll(deque, nums[i-k]);
            myoffer(deque, nums[i]);
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }

    private void myoffer(Deque<Integer> queue, int num){
        if(queue.isEmpty()||queue.peekLast()>=num)
            queue.offerLast(num);
        else{
            while(!queue.isEmpty()&&queue.peekLast()<num) queue.pollLast();
            queue.offerLast(num);
        }
    }

    private void mypoll(Deque<Integer> queue, int num){
        if(queue.peekFirst()==num)  queue.pollFirst();
    }
}
