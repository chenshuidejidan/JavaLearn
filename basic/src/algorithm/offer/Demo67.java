package algorithm.offer;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @Auther: c
 * @Date: 2020/12/15 - 12 - 15 - 15:16
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo67 {
    @Test
    public void Test(){
        System.out.println(strToInt("       -42"));
    }

    public int strToInt(String str) {
        char[] chs = str.toCharArray();
        int start = 0, end = 0;
        while(start<chs.length && !isValidHead(chs[start])) start++;
        end = start+1;
        while(end<chs.length && isValidChar(chs[end])) end++;
        int flag = 1;
        if(chs[start]=='-'){
            flag = -1;
            start++;
        }
        while(chs[start]=='0') start++;
        if(start==end||start==chs.length)   return 0;

        long num = 0;
        end--;
        while(end>start){
            num = num*10+(chs[start]-'0');
            start++;
            if(flag==1 && num>=Integer.MAX_VALUE){
                num = Integer.MAX_VALUE;
                break;
            }else if(flag==-1 && num >= Integer.MAX_VALUE+1){
                num = Integer.MAX_VALUE+1;
                break;
            }
        }
        return (int)(flag*num);
    }


    private boolean isValidHead(char ch){
        if(ch=='-'||ch>='0'&&ch<='9')  return true;
        return false;
    }
    private boolean isValidChar(char ch){
        if(ch>='0'&&ch<='9')  return true;
        return false;
    }
}
