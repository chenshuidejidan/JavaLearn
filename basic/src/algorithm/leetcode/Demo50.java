package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/4 - 12 - 04 - 11:49
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo50 {
    public double myPow(double x, int n) {
        double EOF = 0.000001;
        long n_copy = n;
        if(n_copy==0||Math.abs(x-1)<EOF) return 1.0;
        if(Math.abs(x-0)<EOF)   return 0;
        if(Math.abs(x+1)<EOF)   return n_copy%2==0?1.0:-1.0;
        if(n_copy<0){
            x = 1/x;
            n_copy = n_copy*(-1);
        }
        double result = 1.0;
        while(n_copy>1){
            if(n_copy%2==1)
                result *= x;
            x*=x;
            n_copy=n_copy>>1;
        }
        return result*x;
    }

    @Test
    public void test(){

        System.out.println(myPow(2, 10));
    }
}
