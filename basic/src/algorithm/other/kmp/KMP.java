package algorithm.other.kmp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: c
 * @Date: 2020/11/21 - 11 - 21 - 16:07
 * @Description: algorithm.other.kmp
 * @Version: 1.0
 */
public class KMP {
    /**
     * 求一个字符串的next数组
     *  a   b   a   b   c   a   e   a   f
     * -1   0   0   1   2   0   1   0   1
     */
    protected int[] getNext(char[] chs) {
        int[] next = new int[chs.length];
        next[0] = -1; // next数组中next[0]为-1
        int i = 0;
        int j = -1;
        while (i < chs.length - 1) {
            if (j == -1 || chs[i] == chs[j])
                next[++i] = ++j;
            else
                j = next[j];
        }
        return next;
    }

    public int kmp(String str, String pattern){
        int[] next = getNext(pattern.toCharArray());
        int i = 0, j=0;
        while(i<str.length() && j<pattern.length()){
            if(j==-1||str.charAt(i)==pattern.charAt(j)){
                i++; j++;
            } else{
                j=next[j];
            }
        }
        if(j==pattern.length())     return i-j;
        else return -1;
    }

    @Test
    public void test(){
//        int[] next = getNext("ababc");
//        System.out.println(Arrays.toString(next));
        System.out.println(kmp("abcabababaccabbbababccabc", "ababc"));
    }
}
