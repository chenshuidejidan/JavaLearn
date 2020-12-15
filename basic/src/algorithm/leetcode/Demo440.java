package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/5 - 12 - 05 - 16:28
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while(k>0){
            int count = countNodes(n, cur, cur+1);
            if(count>k){
                cur*=10;
                k-=1;
            } else{
                cur+=1;
                k-=count;
            }
        }
        return cur;
    }

    public int countNodes(int n, long num1, long num2){
        int count = 0;
        while(num1<=n){
            count = (int)(count+Math.min(num2, n+1)-num1);
            num1*=10;
            num2*=10;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(findKthNumber(10, 3));
    }
}
