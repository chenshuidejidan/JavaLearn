package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/12/10 - 12 - 10 - 10:52
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo918 {
    @Test
    public void test(){
        int[] A = {3,1,3};
        System.out.println(maxSubarraySumCircular(A));
    }

    public int maxSubarraySumCircular(int[] A) {
        int[] prefixSum = new int[A.length*2];
        prefixSum[0] = 0;
        int max = A[0];
        for(int i = 1; i<prefixSum.length; i++){
            max = Math.max(A[i],max);
            prefixSum[i]=prefixSum[i-1]+A[(i-1)%A.length];
        }
        if(max<=0)  return max;

        int res = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i<prefixSum.length; i++){
            while(!deque.isEmpty() && prefixSum[deque.peekLast()]>prefixSum[i]) deque.pollLast();
            deque.offerLast(i);
            if(deque.peekFirst()<i-A.length) deque.pollFirst();
            res = Math.max(res, prefixSum[i]-prefixSum[deque.peekFirst()]);
        }
        return res;
    }
}
