package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class Demo6_QuickSort {
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int oriLeft = left;
        int temp = arr[left];
        while(left<=right){
            while(left<=right&&arr[left]<=temp)
                left++;
            while(left<=right&&arr[right]>temp)
                right--;
            if(left<right) swap(arr, left, right);
        }
        swap(arr, oriLeft, right);
        return right;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            quickSort(arr);
            Arrays.sort(arr2);
            if (!Arrays.toString(arr).equals(Arrays.toString(arr2))) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    @Test
    public void test(){
        int[] arr = {3,5,7,23,3,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
