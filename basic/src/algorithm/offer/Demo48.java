package algorithm.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 14:14
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int res = 1;
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<=s.length()-1){
            int countChar = map.getOrDefault(s.charAt(right), 0);
            if(countChar==0){
                map.put(s.charAt(right), 1);
                count++;
                right++;
            }else{
                left++;
                map.put(s.charAt(right),0);
                res = Math.max(res, count);
                count--;
            }
        }
        return Math.max(res, count);
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
