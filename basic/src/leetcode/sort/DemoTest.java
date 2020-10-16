package leetcode.sort;

import java.util.Arrays;

public class DemoTest {
    public static void change(int[] arr){
        arr[0] = 11;
        int[] b = {123};
        arr = b;
    }
    public static void main(String[] args) {
        int[] a = {0,1,2,3};
        change(a);
        System.out.println(Arrays.toString(a));
    }
}
