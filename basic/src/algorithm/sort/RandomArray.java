package algorithm.sort;

import java.util.Random;

public class RandomArray {
    public static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[100000];

        for(int i = 0; i<arr.length; i++)
            arr[i] = r.nextInt(1000000);
        return arr;
    }
}
