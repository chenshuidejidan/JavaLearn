package algorithm.leetcode;

public class Demo69_38 {
    //二分查找
    public int mySqrt(int x) {
        if(x<=0)    return 0;
        long left = 1;
        long right = 2;

        while(right*right<x){
            left = right;
            right *= 2;
        }
        while(left<=right){
            long mid = (left+right)/2;
            long p = mid*mid;
            if(p==x) return (int)mid;
            else if(p>x)    right = mid-1;
            else    left = mid+1;
        }
        return (int)right;
    }

    public int mySqrt2(int x) {
        long i =0;
        long p = i*i;
        while(p<=x) {
            i++;
            p = i*i;
        }
        return (int)i-1;
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(new Demo69_38().mySqrt(x));
    }
}
