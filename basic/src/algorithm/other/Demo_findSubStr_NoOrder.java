package algorithm.other;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Auther: c
 * @Date: 2020/11/19 - 11 - 19 - 19:25
 * @Description: 查找一个字符串str中，是否有连续子串的字符与目标字符串aim完全相同，忽略其顺序。返回任意一个子串的起始位置
 * @Version: 1.0
 */
public class Demo_findSubStr_NoOrder {
    public int findSubStrNoOrder(String str, String aim){
        if(aim.length()>str.length())   return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = aim.length();
        for(int i = 0; i<aim.length(); i++){
            map.put(aim.charAt(i),map.getOrDefault(aim.charAt(i),0)+1);
        }
        for(int i = 0; i<aim.length(); i++){
            Integer integer = map.get(str.charAt(i));
            if(integer !=null){
                map.put(str.charAt(i), integer -1);
                if(integer-1>=0)
                    count--;
            }
        }
        if(count==0)    return 0;
        for(int i = 1; i<=str.length()-aim.length(); i++){
            Integer integer = map.get(str.charAt(i - 1));
            if(integer !=null){
                map.put(str.charAt(i-1), integer +1);
                if(integer+1>0)
                    count++;
            }
            Integer integer2 = map.get(str.charAt(i + aim.length() - 1));
            if(integer2 !=null){
                map.put(str.charAt(i+aim.length()-1), integer2 -1);
                if(integer2-1>=0)
                    count--;
            }
            if(count==0){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        String str = "mjuaboomdsujdduujoommjsfsdfad";
        String aim = "oummjoju";
        System.out.println(findSubStrNoOrder(str, aim));
    }
}
