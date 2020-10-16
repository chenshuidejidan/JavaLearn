package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class Demo6_MergeSort {
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];   //排序前建立临时数组，避免递归中频繁开辟空间
        mergeSort(arr, 0, arr.length-1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left>=right)  return;    //递归出口
        int mid = (left+right)/2;
        mergeSort(arr, left, mid, temp);    //递归排序左边
        mergeSort(arr, mid+1, right, temp); //递归右边
        merge(arr, left, mid, right, temp); //归并
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int index = left;
        int i = left;
        int j = mid+1;
        while(i<=mid&&j<=right){
            // 一定要 <= 才能保证是稳定排序
            temp[index++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
        }
        while(i<=mid)   temp[index++]=arr[i++];
        while(j<=right) temp[index++]=arr[j++];
        // 将当前temp拷贝到原数组
        System.arraycopy(temp, left, arr, left, right-left+1);
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArray.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            mergeSort(arr);
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
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
