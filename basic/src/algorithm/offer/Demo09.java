package algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo09 {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    public Demo09() {

    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            return stack1.pop();
        }else{
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            if(!stack1.isEmpty())   return stack1.pop();
            else return -1;
        }
    }
}
