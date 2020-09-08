package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo38_23 {
    String[] cache = new String[31];
    public String countAndSay(int n) {
        if(n == 1 ){
            cache[1]="1";
            return "1";
        }
        char[] chs = cache[n-1]==null?countAndSay(n-1).toCharArray():cache[n-1].toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<chs.length; i++){
            int pre = i;
            while(i<chs.length-1&&chs[i]==chs[i+1]) i++;
            result.append(i-pre+1);
            result.append(chs[i]);
        }
        cache[n]=result.toString();
        return cache[n];
    }


    public static void main(String[] args) {
        String s = new Demo38_23().countAndSay(5);
        System.out.println(s);
    }
}
