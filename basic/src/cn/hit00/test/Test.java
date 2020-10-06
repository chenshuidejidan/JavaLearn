package cn.hit00.test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] aa) {
        String s1 = new String("ab")+"cc"; //常量池中只有ab 和 cc
        String s2 = s1.intern();    //常量池中不存在abcc，将堆中String对象的引用地址添加到常量池中
        System.out.println(s1 == s2);  //true

        String s3 = "abcc";            //常量池中存在abcc了，是s1的引用地址
        System.out.println(s2 == s3);  //true
        System.out.println(s1 == s3);  //true

        String s4 = new String("abcc");
        String s5 = s4.intern();       //s5还是s1的引用地址
        System.out.println(s4==s5);    //false
    }
}
