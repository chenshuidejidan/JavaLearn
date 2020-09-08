package cn.hit01.array;

public class ArrayNull {
    public static void main(String[] args) {
        int[] a = null;
        System.out.println(a);
        System.out.println(a[0]);    //空指针异常
    }
}
