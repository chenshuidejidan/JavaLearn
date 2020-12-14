package algorithm.sort;

import java.util.Arrays;

public class Demo8_CountSortWithStable {
    public static int[] countSortWithStable(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){ //求最大最小值
            if(arr[i]<min) min = arr[i];
            else if(arr[i]>max) max = arr[i];
        }

        int[] count = new int[max-min+1];  //计数数组
        for(int i = 0; i<arr.length; i++) count[arr[i]-min]++;
        for(int i = 1; i<count.length; i++) count[i]+=count[i-1]; //记录的是该数最后位置

        int[] result = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--){ //重构
            result[--count[arr[i]-min]] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int times = 0; times < 1000; times++) {
            int[] arr = RandomArrayOfLowRange.generateRandomArray();
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = countSortWithStable(arr);
            Arrays.sort(arr2);
            if(!Arrays.toString(arr).equals(Arrays.toString(arr2))){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }


}
