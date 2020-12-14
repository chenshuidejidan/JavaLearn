package algorithm.offer;

import cn.hit03.arraylist.ArrayListBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/30 - 11 - 30 - 15:25
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo43 {
    public int countDigitOne(int n) {
        int high = n/10;
        int cur = n%10;
        int low = 0;
        int bit = 1;
        int count = 0;
        while(!(high==0&&cur==0)){
            if(cur==0)  count+=high*bit;
            else if(cur==1) count=count+bit*high+low+1;
            else    count=count+bit*(high+1);
            low+=cur*bit;
            cur = high%10;
            high/=10;
            bit*=10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Demo43().countDigitOne(20));
    }
}
