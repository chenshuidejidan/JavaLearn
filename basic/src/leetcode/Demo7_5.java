package leetcode;

public class Demo7_5 {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int sgn = x>0 ? 1: -1;
        x*=sgn;
        int result = 0;
        while(x>0){
            int remainder = x%10;
            x = x/10;
            if(result*10/10!=result){   //尝试乘，溢出则肯定不等
                return 0;
            }else{
                result *= 10;
            }
            if(result+remainder-remainder!=result){  //尝试加
                return 0;
            }
            else{
                result += remainder;
            }
        }
        return result*sgn;
    }

    public static void main(String[] args) {
        System.out.println(new Demo7_5().reverse(123));
    }


}
