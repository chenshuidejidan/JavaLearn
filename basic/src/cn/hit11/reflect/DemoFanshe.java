package cn.hit11.reflect;

public class DemoFanshe {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.util.Random");
        System.out.println(clazz);
        System.out.println(clazz.toGenericString());
    }
}
