package cn.hit04.innerClass;

public class OuterClassDemo {
    public static void main(String[] args) {
        OuterClass.Inner inner = new OuterClass().new Inner();
        System.out.println(inner.num);
    }
}
