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
        int res=0, count=0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i  = 0 ; i<height.length; i++){
            if(stack.isEmpty()||height[i]<height[stack.peek()]){
                stack.push(i);
            } else{//高于栈顶，开始统计
                while(height[i]>=height[stack.peek()]){
                    int index = stack.pop();
                    if(stack.isEmpty()){
                        break;
                    }
                    count+=height[index]*(index-stack.peek());
                }
                if(!stack.isEmpty()){
                    res+=(height[i]*(i-stack.peek()+1)-count);
                }
                stack.push(i);
                count = 0;
            }
        }
        return res;
    }
}
