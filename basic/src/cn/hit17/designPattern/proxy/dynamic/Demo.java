package cn.hit17.designPattern.proxy.dynamic;

public class Demo implements IDemo{

    @Override
    public String show1(int i) {
        System.out.println("show1..."+i);
        return "show1..."+i;
    }

    @Override
    public String show2(int i) {
        System.out.println("show2..."+i);
        return "show2..."+i;
    }
}
