package cn.hit04.extend3;

public class Fu {
    int num;
    public Fu(){
        this.num = 1;
        this.test();
    }
    public void test(){
        System.out.println("父亲中的this.num:"+this.num);
    }

}