package leetcode.test;

public class ThisEscape {
    public ThisEscape() {
        System.out.println("ThisEscape ");
        // 在构造方法中其调用了非final和private的方法
        Say();
    }

    public void Say() {
        System.out.println("ThisEscape .Say()");
    }

    public static void main(String[] args) {
        new ThisEscapeSon();
        new ThisEscapeSon("Hello World");
    }
}