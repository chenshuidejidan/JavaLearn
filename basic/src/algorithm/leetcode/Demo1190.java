package algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Auther: c
 * @Date: 2021/4/14 - 04 - 14 - 20:50
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo1190 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(sb.toString());
                sb = new StringBuilder();
            }else if(c == ')'){
                sb = new StringBuilder(stack.pop()).append(sb.reverse());
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo1190().reverseParentheses("(u(love)i)"));
    }
}
