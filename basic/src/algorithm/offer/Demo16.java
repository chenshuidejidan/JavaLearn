package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/11/21 - 11 - 21 - 22:13
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo16 {
    public double myPow(double x, int n) {
        long p = n;
        if(p<0){
            x = 1.0/x;
            p = -p;
        }
        double result = 1.0;
        while(p>0){
            result*=result;
            if((p&1)==1)  result*=x;
            p>>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        new Demo16().myPow(2.0, 10);
    }
}
