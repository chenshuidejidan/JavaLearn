package algorithm.leetcode;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/12/17 - 12 - 17 - 11:04
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo43 {
    @Test
    public void test(){
        System.out.println(multiply("25", "25"));
    }



    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length() + 1];
        int i = 0;
        for(i  = num2.length()-1; i >=0; i--){
            for(int j = num1.length()-1; j>=0; j--){
                arr[num2.length()-1-i + num1.length()-1-j] += (num2.charAt(i)-'0') * (num1.charAt(j)-'0');
            }
        }
        int addNum = 0;
        for(i = 0; i< arr.length; i++){
            int num = arr[i] + addNum;
            addNum = num/10;
            arr[i] = num%10;
        }

        for(i = arr.length-1; i>=0; i--){
            if(arr[i] != 0) break;
        }

        StringBuilder sb = new StringBuilder();
        while(i>=0){
            sb.append(arr[i--]);
        }

        return sb.length()==0 ? "0" : sb.toString();
    }
}
