package algorithm.offer;

/**
 * @Auther: c
 * @Date: 2020/11/23 - 11 - 23 - 16:40
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo39 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int major = 0;
        for(int i = 0; i<nums.length; i++){
            if(vote==0) major = nums[i];
            vote += nums[i]==major?1:-1;
        }
        return major;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,3,2,2};
        new Demo39().majorityElement(arr);
    }
}
