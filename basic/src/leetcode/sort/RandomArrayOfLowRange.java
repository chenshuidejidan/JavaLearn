package leetcode.sort;

import java.util.Random;

public class RandomArrayOfLowRange {
    public static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[10000];

        for(int i = 0; i<arr.length; i++)
            arr[i] = r.nextInt(100);
        return arr;
    }
}
