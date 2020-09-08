package cn.hit14.atomic;


class Num2{
    static volatile boolean flag = false;
    static void change() {
        flag = true;
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {

        System.out.println("操作前：" + Num2.flag);

        while(Num2.flag){

        }
        System.out.println("操作后：" + Num2.flag);
    }
}

public class DemoVolatile2 {

    public static void main(String[] args){

        new Thread(new Task2()).start();
        Num2.change();

    }

}
