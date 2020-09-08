package cn.hit07.system;

public class DemoSystem01 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        demo01();
        long endTime = System.currentTimeMillis();
        System.out.println("\n"+"demo01执行了："+(endTime-startTime)+"ms");
    }

    private static void demo01() {
        //程序执行前获取一次毫秒
        for (int i = 0; i < 1000; i++) {
            System.out.print(i+",");
        }

    }
}
