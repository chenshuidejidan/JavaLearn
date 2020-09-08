package cn.hit07.stringBuilder;

public class DemoStringBuilder {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder("abc");
        StringBuilder s3 = s1.append(s2);  //返回当前对象自身
        System.out.println(s1+"\n"+(s1==s3));

        s1.append(1).append(true).append('啊');
        System.out.println(s1);

        s1.reverse();
        String s4 = s1.toString().toUpperCase();
        System.out.println(s4);
    }
}
