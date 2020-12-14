package algorithm.offer;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 17:13
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        int pivot = 0;
        while(pivot!=k-1){
            pivot = partition(arr, left, right);
            if(pivot<k-1) left = pivot+1;
            if(pivot>k-1) right = pivot-1;
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int left, int right) {
        int index = left;
        int num = arr[index];
        while(left<=right){
            while(left<=right&&arr[left]<=num)  left++;
            while(left<=right&&arr[right]>=num) right--;
            if(left<right) swap(arr, left, right);
        }
        swap(arr, index, right);
        return right;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 78, 546, 6, 3, 34, 6, 876, 9, 999, 4, 32, 45, 6, 5, 2};
        int[] leastNumbers = new Demo40().getLeastNumbers(arr, 4);
        System.out.println(Arrays.toString(leastNumbers));
    }


}
