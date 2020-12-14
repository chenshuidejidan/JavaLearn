package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/11/21 - 11 - 21 - 21:56
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo15 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count += n&1;
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        System.out.println(new Demo15().hammingWeight(n));
    }
}
