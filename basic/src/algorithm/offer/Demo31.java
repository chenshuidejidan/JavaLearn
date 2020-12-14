package algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: c
 * @Date: 2020/11/22 - 11 - 22 - 16:44
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null||popped==null)  return popped==popped;
        if(pushed.length!=popped.length)    return false;
        Deque<Integer> stack = new ArrayDeque<>(pushed.length);
        int i = 0;
        int j = 0;
        while(j<popped.length){
            if(stack.isEmpty()||stack.peek()!=popped[j]){
                if(i>=pushed.length)    return false;
                stack.push(pushed[i++]);
            }
            else{
                stack.pop();
                j++;
            }
        }
        return i==j;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(new Demo31().validateStackSequences(pushed, popped));
    }
}
