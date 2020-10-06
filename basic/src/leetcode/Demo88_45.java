package leetcode;

import java.util.Arrays;

public class Demo88_45 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0){
            for(int j = 0; j<n; j++)
                nums1[j]=nums2[j];
        }
        for(int i = m+n-1; i>=n; i--) nums1[i]=nums1[i-n];
        int i = n, j=0, k = 0;
        while(k<m+n){
            if(i<m+n&&nums1[i]<nums2[j]) nums1[k++]=nums1[i++];
            else nums1[k++]=nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m=0;
        int n=1;
        new Demo88_45().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
