package algorithm.offer;

import org.junit.Test;

/**
 * @Auther: c
 * @Date: 2020/11/30 - 11 - 30 - 13:21
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)   return false;
        int i = 0, j = 0;
        int rowBounds = matrix.length;
        int colBounds = matrix[0].length;
        if(target<matrix[0][0]||target>matrix[rowBounds-1][colBounds-1])    return false;
        while(true){
            while(j<colBounds&&matrix[i][j]<target)  j++;
            if(j<colBounds&&matrix[i][j]==target)    return true;
            j--;
            while(i>=0&&i<rowBounds&&j>=0&&matrix[i][j]>target) j--;
            if(j<0)    return false;
            if(i>=0&&matrix[i][j]==target)    return true;
            i++;
            if(i>=rowBounds)    return false;
        }
    }


    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)   return false;
        int i = 0, j = 0;
        int rowBounds = matrix.length;
        int colBounds = matrix[0].length;
        if(target<matrix[0][0]||target>matrix[rowBounds-1][colBounds-1])    return false;
        while(true){
            if(matrix[i][j]==target)    return true;
            else if(matrix[i][j]>target){
                j = binarySearch(matrix[i], 0, j,target);
            }else{
                j = binarySearch(matrix[i], j+1, matrix[i].length-1, target);
            }
            if(j>=0 && j<matrix[i].length && matrix[i][j]==target)    return true;
            if(i<=0 && matrix[i][j]>target) return false;
            i++;
            if(i>=rowBounds)    return false;
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)>>1;
            if(nums[mid]<target) left = mid+1;
            else if(nums[mid]>target)    right = mid-1;
            else return mid;
        }
        return left>nums.length-1?nums.length-1:left;
    }


    public static void main(String[] args) {
        int[][] matrix = {{-1},{2},{3}};
        int target = 2;
        System.out.println(new Demo04().findNumberIn2DArray2(matrix, target));
    }

    @Test
    public void test(){
        int[] nums1 = {0};
        int[] nums2 = {5};
        System.out.println(binarySearch(nums1, 0, 0, 3));
        System.out.println(binarySearch(nums2, 0, 0, 3));

    }

    public int binarySearchLeft(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)>>1;
            if(nums[mid]<target) left = mid+1;
            else if(nums[mid]>=target)    right = mid-1;
        }
        return left;
    }

    public int binarySearchRight(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)>>1;
            if(nums[mid]<=target) left = mid+1;
            else if(nums[mid]>target)    right = mid-1;
        }
        return right;
    }

    @Test
    public void testLeftRight(){
        int[] nums = {1,2,3,4,4,4,4,5,6};
        System.out.println(binarySearchLeft(nums, 0, nums.length, 4));
        System.out.println(binarySearchRight(nums, 0, nums.length, 4));
    }

}
