package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/12/9 - 12 - 09 - 13:44
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo42 {
    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if(height==null || height.length<3)    return 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<height.length; i++){
            while(!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int nowHeight  = height[stack.pop()];
                if(stack.isEmpty()) break;
                int minHeight = Math.min(height[stack.peek()],height[i]);
                res+=(minHeight-nowHeight)*(i-stack.peek()-1);
            }
            stack.push(i);
        }
        return res;
    }
}
