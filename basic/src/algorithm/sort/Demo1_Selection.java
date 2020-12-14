package algorithm.sort;

import java.util.Arrays;

public class Demo1_Selection {
    public static void selectSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int minIndex = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j]<arr[minIndex])    minIndex=j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            selectSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
