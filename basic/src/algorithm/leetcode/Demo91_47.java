package algorithm.leetcode;

import org.junit.Test;

public class Demo91_47 {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)<='0'||s.charAt(0)>'9')  return 0;
        if(s.equals("10"))  return 1;
        int length = s.length();
        int[] dp = new int[length+1];
        char[] ch = s.toCharArray();
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=length; i++){
            int value = ((int)(ch[i-2]-'0')*10+(int)(ch[i-1]-'0'));
            if(value==10||value==20) dp[i]=dp[i-2];
            else if(value>10&&value<=26) dp[i] = dp[i-1]+dp[i-2];
            else if(value<10&&value>0||value>26&&value%10!=0) dp[i] = dp[i-1];
            else return 0;
        }
        return dp[length];
    }

    @Test
    public void test1() {
        String s = "12120";
        int i = numDecodings(s);
        System.out.println(i);
    }

    public int numDecodings2(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')  return 0;
        if(s.length()==1)   return 1;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)=='0'&&(s.charAt(i-1)!='1'&&s.charAt(i-1)!='2'))    return 0;
        }
        char[] chs = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if(chs[1]=='0'||chs[0]=='2'&&chs[1]>'6'||chs[0]>'2') dp[1]=1;
        else dp[1]=2;
        for(int i = 2; i<s.length(); i++){
            if(chs[i]=='0')  dp[i]=dp[i-2];
            else if(chs[i-1]=='0'||chs[i-1]=='2'&&chs[i]>'6'||chs[i-1]>'2')  dp[i]=dp[i-1];
            else dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[s.length()-1];
    }
    @Test
    public void test(){
        System.out.println(numDecodings2("10"));
    }
}
