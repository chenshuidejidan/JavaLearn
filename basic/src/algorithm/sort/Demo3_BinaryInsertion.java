package algorithm.sort;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/11/21 - 11 - 21 - 11:16
 * @Description: algorithm.sort
 * @Version: 1.0
 */
public class Demo3_BinaryInsertion {
    public int binarySearchIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+((right-left)>>1);
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    @Test
    public void test(){
        int[] arr = {1,2,3,5,6,7};
        System.out.println(binarySearchIndex(arr, 0));
    }

}
