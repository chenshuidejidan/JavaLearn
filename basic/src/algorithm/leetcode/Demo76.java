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
        String s = "a";

        String t = "A";
        System.out.println(minWindow2(s, t));
    }

    public String minWindow2(String s, String t) {
        int left = 0, right = 0, resl = 0, resr = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int total = map.size();
        char[] chs = s.toCharArray();
        for (right = 0; right < chs.length; right++) {
            while (right < chs.length && !map.containsKey(chs[right])) right++;
            if (right >= chs.length) break;

            if (map.get(chs[right]) == 1) total--;
            map.put(chs[right], map.get(chs[right]) - 1);

            while (left <= right && (!map.containsKey(chs[left]) || map.get(chs[left]) < 0)) {
                if (map.containsKey(chs[left])) map.put(chs[left], map.get(chs[left]) + 1);
                left++;
            }

            if (total == 0 && (resr == -1 || resr - resl > right - left)) {
                resl = left;
                resr = right;
            }
        }
        return resr == -1 ? "" : s.substring(resl, resr + 1);
    }
}
