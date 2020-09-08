package cn.hit03.string;

public class StringDemoEquals {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        char[] c = {'a','b','c'};
        String s3 = new String(c);
        System.out.println(s1 == s2);          //true
        System.out.println(s1 == s3);          //false
        System.out.println(s2 == s3);          //false
        System.out.println(s1.equals(s3));     //true

    }
}
