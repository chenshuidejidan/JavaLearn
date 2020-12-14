package algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2020/12/9 - 12 - 09 - 16:34
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int total = map.size(), count = 0;
        Integer temp = null;
        String res = "";
        for(int left = 0, right = 0; right <s.length(); right ++){

            while(right<s.length() && !map.containsKey(s.charAt(right)))  right++;
            if(right==s.length())   break;
            map.put(s.charAt(right), temp-1);
            if(temp==1) count++;

            while((temp = map.get(s.charAt(left)))==null||temp<0){
                if(temp!=null)  map.put(s.charAt(left), temp+1);
                left++;
            }
            if(count==total){
                if(res.length()==0||res.length()>right-left+1)  res = s.substring(left,right+1);
            }
        }
        return res;
    }
    @Test
    public void test(){
        String s = "ADOBECODEBANC";

        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
