package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class Demo7_DualPivotQuickSort {
    public static void dualPivotQuickSort(int[] arr) {
        dualPivotQuickSort2(arr, 0, arr.length - 1);
    }

    private static void dualPivotQuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left+1, j = right-1, k = left + 1;
        if (arr[left] > arr[right]) swap(arr, left, right);
        int pivot1 = arr[left], pivot2 = arr[right];
        while (k <= j) {
            if(arr[k]<=pivot1) {
                if (arr[i] <= pivot1) swap(arr, i++, k++);
                else swap(arr, i++, k);
            }
            else if(arr[k]>=pivot2){
                while(arr[j]>=pivot2 && j>=k)
                    j--;
                if(k<j)
                    swap(arr, k, j--);
            } else  k++;
        }
        swap(arr, i-1, left);
        swap(arr, j+1, right);
        dualPivotQuickSort(arr, left, i-2);
        dualPivotQuickSort(arr, i, j);
        dualPivotQuickSort(arr, j+2, right);
    }

    public static void dualPivotQuickSort2(int[] arr, int left, int right) {
        if (left >= right) return;
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        int pivot1 = arr[left], pivot2 = arr[right];
        int i = left, j = right, k = left + 1;
        while (k < j) {
            if (arr[k] < pivot1) {
                swap(arr, ++i, k++);
            } else if (arr[k] <= pivot2) {
                k++;
            } else {
                while (k < j && arr[--j] > pivot2);
                if(k>=j)    break;
                swap(arr, j, k);
            }
        }
        swap(arr, left, i);
        swap(arr, right, j);

        dualPivotQuickSort(arr, left, i - 1);
        dualPivotQuickSort(arr, i + 1, j - 1);
        dualPivotQuickSort(arr, j + 1, right);
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
            dualPivotQuickSort(arr);
        }
        long time1 = new Date().getTime();
        System.out.println(time1-time + "ms");
    }

    @Test
    public void test(){
        int[] arr = {1,4,3,3,6};
        dualPivotQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
