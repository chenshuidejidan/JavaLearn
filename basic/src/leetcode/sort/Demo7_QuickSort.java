package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class Demo7_QuickSort {
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int pivot = partition2(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    //最简单的划分方式
    private static int partition(int[] arr, int left, int right) {
        int oriLeft = left;
        int temp = arr[left];
        while(left<=right){
            while(left<=right&&arr[left]<=temp)
                left++;
            while(left<=right&&arr[right]>=temp)
                right--;
            if(left<right) swap(arr, left++, right--);
        }
        swap(arr, oriLeft, right);
        return right;
    }

    //进阶的划分方式，减少交换次数
    private static int partition2(int[] arr, int left, int right){
        int temp = arr[left];
        while(left<right){
            //一定要先看右边，因为左边第一位必须要先覆盖掉
            while(left<right && arr[right]>=temp)    right--;
            if(left<right)  arr[left++] = arr[right];
            while(left<right && arr[left]<=temp)   left++;
            if(left<right)  arr[right--] = arr[left];
        }
        arr[left] = temp; //此时left==right，用哪个都无所谓
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        long time = new Date().getTime();
        for (int times = 0; times < 10000; times++) {
            int[] arr = RandomArrayOfLowRange.generateRandomArray();
//            quickSort(arr);
            Arrays.sort(arr);
        }
        long time1 = new Date().getTime();
        System.out.println(time1-time + "ms");
    }


    @Test
    public void test(){
        int[] arr = {2,3,4,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
