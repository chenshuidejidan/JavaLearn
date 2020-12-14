package algorithm.sort;

import java.util.Arrays;

public class Demo2_BubbleSort {
    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for(int i = arr.length-1; i>0; i--){    //每次冒泡的结束处
            flag = false;
            for (int j = 0; j < i; j++) {   //交换冒泡
                if(arr[j]>arr[j+1]){
                    arr[j]+=arr[j+1];
                    arr[j+1] = arr[j]-arr[j+1];
                    arr[j]-=arr[j+1];
                    flag = true;
                }
            }
            if(flag == false) return;   //无交换直接返回
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            bubbleSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
