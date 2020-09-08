package leetcode;

public class Demo55_32 {
    //贪心算法，维护一个最远值
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)  return false;
        if(nums.length==1) return true;
        int far = nums[0];
        for(int i=0; i<nums.length; i++){
            if(i<=far){
                far = Math.max(far, i+nums[i]);
                if(far>=nums.length-1)  return true;
            }
        }
        return false;
    }

    //往回回溯，查找<=n, <=n-1, <=n-2, ... <=3, <=2, <=1,0 的形式
    public boolean canJump2(int[] nums) {
        if(nums==null||nums.length==0)  return false;
        if(nums.length==1) return true;
        for(int i = 0; i<nums.length-1; i++){   //最后一个位置的数不管，否则最后为0影响判断
            if(nums[i]==0){
                int j = i;
                int count = 0;
                while(j>=0&&nums[j] <= count){
                    j--; count++;
                    if(j<0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        boolean b = new Demo55_32().canJump(nums);
        System.out.println(b);
    }
}
