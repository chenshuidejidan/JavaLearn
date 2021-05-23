package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2021/4/14 - 04 - 14 - 16:46
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo409_129 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int res = 0;
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(e.getValue()>0){
                res += e.getValue()>>1<<1;
                if(e.getValue()%2==1 && res%2==1)   res++;
            }
        }
        return res;
    }
}
