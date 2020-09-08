package cn.hit12.lambda;

import java.util.Random;
import java.util.function.Supplier;

class DemoLambda2 {
    public static void main(String[] args) {
        String s1 = "hello ";
        String s2 = "java";
        String s3 = "!";
        myFunction(new Random().nextInt(2), s1+s2+s3);

        myFunction(new Random().nextInt(2), ()->s1+s2+s3);
    }

    static void myFunction(int i, String s){
        if(i == 1){
            System.out.println(s);
        }
    }
    static void myFunction(int i, Supplier<String> s){
        if(i == 1){
            System.out.println(s.get());
        }
    }
}
