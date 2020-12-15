package algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo3_3 {
    public int lengthOfLongestSubstring(String s) {
        //HashMap实现
        if(s==null||s.length()==0) return 0;
        int right = 0;
        int left = 0;
        int maxLength = 0;  //记录结果
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<s.length()){
            map.put(s.charAt(right), right);

            //收紧左侧窗口
            if(map.containsKey(s.charAt(right))){
                //left变为离right处最近的重复字母+1
                //max保证left不会回退：如abba 保证right到达第二个a时left不会回退到第一个a处
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length()==0) return 0;
        int res = 1;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<s.length()){
            int posChar = map.getOrDefault(s.charAt(right), -1);
            if(posChar<left){
                map.put(s.charAt(right), right);
                right++;
            }else{
                res = Math.max(res, right-left);
                left = posChar+1;
                map.put(s.charAt(right), right);
            }
        }
        return Math.max(res, right-left);
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring2("aab"));
    }

}
