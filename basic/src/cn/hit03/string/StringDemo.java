package cn.hit03.string;

public class StringDemo {
    public static void main(String[] args) {
        //字符串内容不可变！
        //3+1种创建方式
        String s1 = new String();     //空字符串

        char[] c = new char[]{'a','b','q'};
        String s2 = new String(c);    //根据字符数组创建

        byte[] b = {97, 99, 98};
        String s3 = new String(b);    //根据byte数组创建

        String s4 = "hello";          //直接创建

    }
}
