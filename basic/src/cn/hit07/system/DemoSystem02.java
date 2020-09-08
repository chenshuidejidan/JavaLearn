package cn.hit07.system;

import java.util.Arrays;

public class DemoSystem02 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9,10};
        System.arraycopy(a,1,b,0,3);
        System.out.println("a:"+ Arrays.toString(a)+"\nb:"+Arrays.toString(b));
    }
}
