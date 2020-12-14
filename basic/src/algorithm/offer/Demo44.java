package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/11/30 - 11 - 30 - 16:15
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo44 {
    public int findNthDigit(int n) {
        if(n<=10)   return n;
        long start = 10; //当前位数的数字的起始数字
        int i = 1;  //位数
        long count = 9;  //前面已经有多少位
        for(i = 2; count+(9*start)*i<n;i++){
            count+=(9*start)*i;
            start*=10;
        }

        long num = start+(n-count-1)/i;
        int bit = (int) ((n-count-1)%i);
        return String.valueOf(num).charAt(bit)-'0';
    }

    public static void main(String[] args) {
        System.out.println(new Demo44().findNthDigit(1000000000));
    }
}
