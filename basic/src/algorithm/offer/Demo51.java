package algorithm.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: c
 * @Date: 2020/11/30 - 11 - 30 - 10:51
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo51 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if(left>=right)  return 0;
        int mid = (left+right)>>1;
        int countReversePairs1 = mergeSort(nums, left, mid);
        int countReversePaies2 = mergeSort(nums, mid+1, right);
        return countReversePairs1+countReversePaies2+merge(nums, left, mid, mid+1,right);
    }

    private int merge(int[] nums, int left1, int right1, int left2, int right2) {
        int[] nums1;
        int[] nums2;
        if(left1>right1){
            nums1=new int[0];
        }else{
            nums1 = new int[right1-left1+1];
            System.arraycopy(nums,left1,nums1,0,right1-left1+1);
        }
        if(left2>right2){
            nums2=new int[0];
        }else{
            nums2 = new int[right2-left2+1];
            System.arraycopy(nums,left2,nums2,0,right2-left2+1);
        }

        int countReversePairs3 = 0;
        int index1 = 0; int index2 = 0;
        for(int i = left1; i<=right2; i++){
            if(index1<nums1.length&&index2<nums2.length){
                if(nums1[index1]<=nums2[index2]) nums[i]=nums1[index1++];
                else{
                    nums[i]=nums2[index2++];
                    countReversePairs3+=(nums1.length-index1);
                }
            } else if(index1<nums1.length){
                nums[i]=nums1[index1++];
            } else{
                nums[i]=nums2[index2++];
            }
        }
        return countReversePairs3;
    }

    @Test
    public void test(){
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }

}
