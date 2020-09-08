package cn.hit04.extend;

public interface MyInterface {
    public static void methodS1(){
        System.out.println("静态方法1");
        methodSCommon();
    }
    public static void methodS2(){
        System.out.println("静态方法2");
        methodSCommon();
    }
    private static void methodSCommon(){
        System.out.println("静态方法共有的部分代码");
    }

    public default void methodD1(){
        System.out.println("默认方法1");
    }
    public default void methodD2(){
        System.out.println("默认方法2");
    }
    private void methodDCommon(){
        System.out.println("默认方法共有的部分代码");
    }
}
