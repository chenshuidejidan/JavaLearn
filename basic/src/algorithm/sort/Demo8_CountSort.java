package algorithm.sort;

import java.util.Arrays;

public class Demo8_CountSort {
    public static void countSort(int[] arr){
        int min = arr[0];
        int max = arr[1];
        for(int i = 0; i < arr.length; i++){ //求最大最小值
            if(arr[i]<min) min = arr[i];
            else if(arr[i]>max) max = arr[i];
        }

        int[] count = new int[max-min+1];  //计数数组
        for(int i = 0; i<arr.length; i++) count[arr[i]-min]++;

        for(int i = 0, j=0; i<count.length; i++){ //重构
            int value = min + i;
            while(count[i]-- >0) arr[j++]=value;
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArrayOfLowRange.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            countSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
