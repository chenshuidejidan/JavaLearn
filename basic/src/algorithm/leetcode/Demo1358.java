package algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: c
 * @Date: 2020/12/10 - 12 - 10 - 11:35
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo1358 {
    @Test
    public void test(){
        String s = "ababc";
        System.out.println(numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0, res = 0;
        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right)-'a']++;
            while(count[0]>=1 && count[1]>=1 && count[2]>=1){
                res += s.length()-right;
                count[s.charAt(left)-'a']--;
                left++;
            }
        }
        return res;
    }
}
