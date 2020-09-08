package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Demo20_14 {
    public boolean isValid(String s) {
        if(s==null||s.length()==0||s.length()%2==1)
            return false;
        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:chs){
            if(ch=='('||ch=='['||ch=='{')
                stack.push(ch);
            else{
                if(stack.pop()!=ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
