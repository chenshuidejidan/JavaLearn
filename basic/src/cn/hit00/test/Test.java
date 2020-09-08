package cn.hit00.test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int right = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                //left变为离right处最近的重复字母+1
                //max保证left不会回退：如abba 保证right到达第二个a时left不会回退到第一个a处
                left = Math.max(left,map.get(s.charAt(right))+1);
            }

            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int lengthOfLongestSubstring = new Test().lengthOfLongestSubstring("abba");
        System.out.println(lengthOfLongestSubstring);
    }

}
