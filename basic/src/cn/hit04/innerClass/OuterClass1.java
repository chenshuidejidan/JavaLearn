package cn.hit04.innerClass;

public class OuterClass1 {
    private int num = 10;
    public class InnerClass{  //成员内部类
        public void showNum(){
            System.out.println(num);
        }

    }
}
