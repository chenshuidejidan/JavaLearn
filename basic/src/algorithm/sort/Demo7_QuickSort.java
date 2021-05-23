package algorithm.sort;

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

    private static void quickSortSmallRec(int[] arr){
        quickSortSmallRec(arr, 0, arr.length-1);
    }

    private static void quickSortSmallRec(int[] arr, int head, int tail){
        while(head<tail){
            int l = head, r = tail, temp = arr[(head+tail)/2];
            do{
                while(l<=r && arr[l]<temp) l++;
                while(l<=r && arr[r]>temp) r--;
                if(l<=r){
                    swap(arr, l, r);
                    l++; r--;
                }
            }while(l<=r);
            quickSortSmallRec(arr, head, r);
            head = l;
        }
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

//    public static void main(String[] args) {
//        boolean flag = true;
//        for (int times = 0; times < 1000; times++) {
//            int[] arr = RandomArrayOfLowRange.generateRandomArray();
//            int[] arr2 = new int[arr.length];
//            System.arraycopy(arr, 0, arr2, 0, arr.length);
//            quickSortSmallRec(arr);
//            Arrays.sort(arr2);
//            if(!Arrays.toString(arr).equals(Arrays.toString(arr2))){
//                flag = false;
//                break;
//            }
//        }
//        System.out.println(flag);
//
//    }


    public static void main(String[] args) {
        long time = new Date().getTime();
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArrayOfLowRange.generateRandomArray();
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
