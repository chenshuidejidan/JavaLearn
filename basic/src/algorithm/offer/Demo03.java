package algorithm.offer;

public class Demo03 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        for(i = 0; i< nums.length; i++){
            while(nums[i]!=i){
                if(nums[nums[i]]==nums[i])
                    return nums[i];
                else
                    swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
