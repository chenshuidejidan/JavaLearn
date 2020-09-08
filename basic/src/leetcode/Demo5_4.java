package leetcode;

import java.util.Arrays;

public class Demo5_4 {
    //中心扩散
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String longestString = s.substring(0, 1);
        char[] chars = s.toCharArray();
        int len = s.length();
        int left = 0;
        int right = 0;
        int longestNow = 1;
        int longestLeft = 0;
        int longestRight = 0;

        for (int i = 1; i < len; i++) {
            if(chars[i]==chars[i-1]){
                longestNow = 2;
                left = i-2;
                right = i+1;
                while(right<len && left>=0 && chars[right]==chars[left]){
                    longestNow+=2;
                    right++;
                    left--;
                }
                if(longestNow>longestRight-longestLeft){
                    longestLeft = left+1;
                    longestRight = right-1;
                }
            }
            if(i-2>=0&&chars[i]==chars[i-2]){
                longestNow = 3;
                left = i-3;
                right = i+1;
                while(right<len && left>=0 && chars[right]==chars[left]){
                    longestNow+=2;
                    right++;
                    left--;
                }
                if(longestNow>longestRight-longestLeft){
                    longestLeft = left+1;
                    longestRight = right-1;
                }
            }

        }
        return longestString.length()<longestRight-longestLeft+1?s.substring(longestLeft, longestRight+1):longestString;
    }


    //动态规划
    public String longestPalindrome2(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int longestStart = 0;
        int longestEnd = 0;
        char[] chars = s.toCharArray();

        for(int step=0; step<len; step++){
            for (int i = 0; i + step < len; i++) {
                if(step==0||chars[i]==chars[i+step]&&(dp[i+1][i+step-1]||step==1)){
                    dp[i][i+step] = true;
                    if(longestEnd-longestStart<step){
                        longestStart = i;
                        longestEnd = i+step;
                    }
                }
            }
        }
        return s.substring(longestStart, longestEnd+1);
    }

    public static void main(String[] args) {
        String longest = new Demo5_4().longestPalindrome("cbbd");
        System.out.println(longest);
    }
}
