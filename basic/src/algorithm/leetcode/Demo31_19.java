package algorithm.leetcode;

import java.util.Arrays;

public class Demo31_19 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2)
            return;

        int ordered = nums.length-1;    //最后一对顺序数的后者
        for(ordered = nums.length-1; ordered>=1&&nums[ordered-1]>=nums[ordered]; ordered--);
        if(ordered==0){ //没有顺序数，全逆序
            Arrays.sort(nums);
            return;
        }
        ordered--; //顺序数的左元素
        //找order右侧比nums[order]大的最接近的数
        int rightMin = ordered+1;
        for(int i = ordered+1; i<nums.length&&nums[i]>nums[ordered]; i++)
            rightMin = i;
        //交换
        int temp = nums[rightMin];
        nums[rightMin] = nums[ordered];
        nums[ordered] = temp;
        //对右侧排序
        Arrays.sort(nums, ordered+1, nums.length);
//        for(int i = nums.length-1; i>ordered; i--){
//            int flag = 0;
//            for(int j=ordered+1; j<i; j++){
//                if(nums[j+1]<nums[j]){
//                    temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                    flag = 1;
//                }
//            }
//            if(flag==0) break;
//        }
    }

    public static void main(String[] args) {
        int[] nums = {1,7,5,5};
        new Demo31_19().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
