package algorithm.leetcode;

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

    public static void main(String[] args) {
        String s = "12120";
        int i = new Demo91_47().numDecodings(s);
        System.out.println(i);
    }
}
