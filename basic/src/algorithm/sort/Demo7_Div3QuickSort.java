package algorithm.sort;

import org.junit.Test;

import java.util.Date;

public class Demo7_Div3QuickSort {
    public static void div3QuickSort(int[] arr){
        div3QuickSort(arr, 0, arr.length-1);
    }
    private static void div3QuickSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int pivot = arr[left];
        int i = left, j = right, k=left+1;
        while(k<=j){
            if(arr[k]<pivot)  swap(arr, i++, k++);
            else if(arr[k]>pivot)   swap(arr, j--, k);
            else k++;
        }
        div3QuickSort(arr, left, i-1);
        div3QuickSort(arr, j+1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        long time = new Date().getTime();
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            div3QuickSort(arr);
        }
        long time1 = new Date().getTime();
        System.out.println(time1-time + "ms");
    }

    @Test
    public void test(){
        int[] arr = {5,4,7,8,23,1,9,3,5,4};
        div3QuickSort(arr);
    }
}
