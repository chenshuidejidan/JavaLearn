package leetcode.sort;

import java.util.Arrays;

public class Demo3_Insertion {
    public static void insertionSort(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            insertionSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
