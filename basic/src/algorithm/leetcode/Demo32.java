package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/9 - 12 - 09 - 18:51
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo32 {
    public int longestValidParentheses(String s) {



        int longest = 0, start = 0, count = 0, valid = -1;
        int cur = start;
        while(start<s.length() && cur<s.length()){
                if(s.charAt(cur)=='('){
                    count+=1;
                }else{
                    count += -1;
                }
                if(count ==0){
                    valid = cur;    //start到cur是合法序列
                    longest = Math.max(longest, valid-start+1);
                }
                if(count<0){
                    start = cur+1;
                    count = 0;
                }
                cur++;
        }

        start = s.length()-1; cur = start; valid = s.length(); count=0;
        while(start>=0 && cur>=0){
            if(s.charAt(cur)=='('){
                count+=1;
            }else{
                count += -1;
            }
            if(count ==0){
                valid = cur;    //start到cur是合法序列
                longest = Math.max(longest, start-valid+1);
            }
            if(count>0){
                start = cur-1;
                count = 0;
            }
            cur--;
        }
        return longest;
    }

    @Test
    public void test(){
        String s = "()";
        System.out.println(longestValidParentheses(s));
    }
}
