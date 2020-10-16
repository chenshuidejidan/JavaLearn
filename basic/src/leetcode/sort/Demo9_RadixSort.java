package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class Demo9_RadixSort {
    public static void radixSort(int[] arr){
        int maxBits = getMaxBits(arr);  //最大数的位数
        int[] result = new int[arr.length];
        int[] count = new int[10];  //每一位计数从0-9

        //对所有数，按10进制位依次进行计数排序
        for(int i =0; i<maxBits; i++){
            int division = (int)Math.pow(10, i);

            //对第i位进行稳定的计数排序
            for(int j = 0; j<arr.length; j++){
                count[arr[j]/division%10]++;
            }
            for(int j = 1; j< count.length; j++)   count[j]+=count[j-1];
            for(int j = arr.length-1; j>=0; j--){
                result[--count[arr[j]/division%10]] = arr[j];
            }

            //复原count，将结果保存到arr
            Arrays.fill(count, 0);
            System.arraycopy(result, 0, arr, 0, arr.length);
        }

    }

    private static int getMaxBits(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max) max=arr[i];
        }
        int maxBits = 0;  //最大位数
        while(max>0){
            max/=10;
            maxBits++;
        }
        return maxBits;
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArrayOfLowRange.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            radixSort(arr);
            Arrays.sort(arr2);
            if(!Arrays.toString(arr).equals(Arrays.toString(arr2))){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    @Test
    public void test(){
        int[] arr = {3,5,7,23,3,4,13,14,33,34,73,74,53,54,93,94,133,154,153,134,993,994};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
