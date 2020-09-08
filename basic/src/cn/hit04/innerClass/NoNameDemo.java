package cn.hit04.innerClass;

public class NoNameDemo {
    public static void main(String[] args) {
        NoName a = new NoName() {  //匿名内部类
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法1");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法2");
            }

        };
        a.method1();
        a.method2();

        new NoName(){  //匿名对象，只能调用一次方法
            @Override
            public void method1() {
                System.out.println("匿名对象实现了方法1");
            }

            @Override
            public void method2() {
                System.out.println("匿名对象实现了方法2");
            }
        }.method1();
    }
}
