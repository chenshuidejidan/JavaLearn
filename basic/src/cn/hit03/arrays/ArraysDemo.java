package cn.hit03.arrays;

import cn.hit01.array.Array;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] a = {20, 30, 10};
        String s = Arrays.toString(a);   //将数组元素变为字符串
        System.out.println(s);

        Arrays.sort(a);                 //升序排序
        System.out.println(Arrays.toString(a));
    }
}
