package leetcode;

public class Demo516 {
    public int longestPalindromeSubseq(String s) {
        if(s==null||s.length()==0)
            return 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++)
            dp[i][i] = 1;

        for (int i = 2; i <= length; i++) {    //子串的长度
            for(int start = 0; start+i-1<length; start++){      //字串起点
                if(chars[start]==chars[start+i-1]){
                    if(i==2)
                        dp[start][start+i-1]=2;
                    else
                        dp[start][start+i-1] = dp[start+1][start+i-2]+2;
                }else{
                    dp[start][start+i-1] = Math.max(dp[start][start+i-2], dp[start+1][start+i-1]);
                }
            }
        }
        return dp[0][length-1]==0?1:dp[0][length-1];
    }

    public static void main(String[] args) {
        String input = "bbbab";
        System.out.println(new Demo516().longestPalindromeSubseq(input));
    }

}
