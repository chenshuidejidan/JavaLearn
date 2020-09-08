package cn.hit01.array;

public class Array {
    public static void main(String[] args) {
        int[] a = new int[10];  //动态初始化，指定长度
        int[] b = new int[]{1,2,3}; //静态初始化，指定内容
        int[] c = {1,2,3,4};  //静态初始化，省略格式
        System.out.println(a);
        System.out.println(b[0]);

        int len_b = b.length;       //获取长度

        System.out.println("b数组长度:"+len_b);
    }

}
