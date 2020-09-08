package cn.hit08.wrapperClass;


public class DemoWrapperClass {
    public static void main(String[] args) {
        Integer in1 = new Integer(10); //方法过时了
        Integer in2 = new Integer("10"); //方法过时了
        System.out.println(in1+"\n"+in2);

        Integer in3 = Integer.valueOf(1);   //使用静态方法
        int i = in3.intValue();

        int i1 = Integer.parseInt("123");
        String s1 = Integer.toString(i1);
        String s2 = String.valueOf(i1);

    }
}
