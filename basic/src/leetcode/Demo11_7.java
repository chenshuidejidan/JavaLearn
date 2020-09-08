package leetcode;

public class Demo11_7 {
    //双指针
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxCapacity = Math.min(height[left],height[right]);

        while(left<right){
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
            maxCapacity = Math.max(Math.min(height[left],height[right])*(right-left),maxCapacity);
        }


        return maxCapacity;
    }


    //动态规划超时
    public int maxArea2(int[] height) {
        int len = height.length;
        int[][] dp = new int[len][len];
        int max = 0;
        for(int step = 1; step<len; step++){
            for(int i = 0; i+step<len; i++){
                if(step==1) dp[i][i+step] = Math.min(height[i],height[i+step]);
                else{
                    dp[i][i+step]=Math.max(Math.max(dp[i][i+step-1], dp[i+1][i+step]), Math.min(height[i],height[i+step])*step);
                }
                if(dp[i][i+step]>max){
                    max = dp[i][i+step];
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Demo11_7().maxArea(a));
    }
}
