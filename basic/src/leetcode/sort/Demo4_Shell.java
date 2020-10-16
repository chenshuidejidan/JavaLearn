package leetcode.sort;

import java.util.Arrays;

public class Demo4_Shell {
    public static void shellSort(int[] arr){
        int gap = (int)Math.floor(Math.sqrt(arr.length));
        while(gap>=1){
            for(int i = 0; i<gap; i++){
                for(int j = i+gap; j<arr.length; j+=gap){
                    int temp = arr[j];
                    int k = j-gap;
                    while(k>=0 && arr[k]>temp){
                        arr[k+gap]=arr[k];
                        k-=gap;
                    }
                    arr[k+gap] = temp;
                }
            }
            gap/=2;
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            shellSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
