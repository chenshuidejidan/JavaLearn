package algorithm.offer;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 13:51
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo58 {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int start = chs.length-1, end = chs.length;
        StringBuilder sb = new StringBuilder();
        while(end>0){
            while(start>=0 && chs[start]==' '){
                start--; end--;
            }
            while(start>=0 && chs[start]!=' '){
                start--;
            }
            if(end<0)  break;
            start++;
            sb.append(s.substring(start, end));
            sb.append(' ');
            end=start;
            start--;
        }
        return sb.toString().trim();
    }

    @Test
    public void test(){
        System.out.println(reverseWords("a"));
    }
}
