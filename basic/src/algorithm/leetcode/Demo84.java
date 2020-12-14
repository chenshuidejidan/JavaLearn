package algorithm.leetcode;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/12/9 - 12 - 09 - 22:25
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo84 {
    @Test
    public void test(){
        int[] heights = {2,4};
        System.out.println(largestRectangleArea(heights));
    }


    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)   return 0;
        //枚举柱形的高度，该高度对应面积就是左右边第一个比它小的位置
        int[] leftLow = new int[heights.length];
        int[] rightLow = new int[heights.length];
        int res = 0;
        Deque<Integer> stack  = new ArrayDeque<>();
        for(int i = 0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])  stack.pop();
            if(stack.isEmpty()) leftLow[i] = -1;
            else    leftLow[i] = stack.peek();
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();

        for(int i= heights.length-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) rightLow[i] = heights.length;
            else rightLow[i] = stack.peek();
            stack.push(i);
        }

        for(int i = 0 ; i<heights.length; i++){
            res = Math.max(res, heights[i]*(rightLow[i]-leftLow[i]-1));
        }
        return res;
    }
}
