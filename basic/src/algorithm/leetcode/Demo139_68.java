package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo139_68 {
    public boolean endwith(char[] c1, int lastIndex, char[] c2){
        if(c2.length>lastIndex+1) return false;
        int i = lastIndex;
        int j = c2.length-1;
        while(c1[i]==c2[j]){
            i--;j--;
            if(j==-1)   return true;
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1]; //dp[n]，表示前n位置的字符串可以被wordDict拆分
        dp[0]=true;
        int minWordLen = Integer.MAX_VALUE;
        for(int i = 0; i<wordDict.size(); i++){
            String word = wordDict.get(i);
            if(word.length()<minWordLen)    minWordLen = word.length();
            if(minWordLen==1)   break;
        }
        List<char[]> wordDictOfChar = new ArrayList<>(wordDict.size());
        for(String str:wordDict){
            wordDictOfChar.add(str.toCharArray());
        }
        char[] chars = s.toCharArray();
        for(int j = minWordLen; j<=s.length(); j++){
            for(int i = 0;i<wordDict.size(); i++){
                if(endwith(chars, j-1, wordDictOfChar.get(i))&&
                        dp[j-wordDictOfChar.get(i).length]==true)
                    dp[j]=true;
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test(){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] words = {"a","aa","aaa","aaaa"};
        List wordDict = Arrays.asList(words);
        System.out.println(wordBreak(s, wordDict));
    }
}
