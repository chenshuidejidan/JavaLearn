package cn.hit04.extend3;

public class Zi extends Fu{
    int num = 2;
    public Zi(){
        test();
    }

    @Override
    public void test() {
        System.out.println("子类中的this.num:" + this.num);
    }
}