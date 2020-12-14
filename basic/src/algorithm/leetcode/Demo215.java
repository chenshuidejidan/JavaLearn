package algorithm.leetcode;

/**
 * @Auther: c
 * @Date: 2020/12/6 - 12 - 06 - 20:32
 * @Description: algorithm.leetcode
 * @Version: 1.0
 */
public class Demo215 {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length)   return -1;

        int index = partition(nums, 0, nums.length-1, k);
        while(index!=nums.length-k){
            if(index<nums.length-k) index = partition(nums, index+1, nums.length-1, k);
            else    index = partition(nums, 0, index-1,k);
        }
        return nums[index];
    }

    public int partition(int[] nums, int left, int right, int k){
        int pivot = left;
        while(left<=right){
            while(left<=right && nums[left]<=nums[pivot]){
                left++;
            }
            while(left<=right && nums[right]>=nums[pivot]){
                right--;
            }
            if(left<right)  swap(nums, left, right);
        }
        swap(nums, pivot, right);
        return right;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        new Demo215().findKthLargest(nums,k);
    }
}
