package cn.proxy;

public class Demo1Impl implements Demo1{
    public String show1(int i){
        System.out.println("show1......"+i);
        return "show1......"+i;
    }
    public String show2(int i){
        System.out.println("show2......"+i);
        return "show2......"+i;
    }
}
