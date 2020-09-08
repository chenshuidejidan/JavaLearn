package cn.hit.servlet1;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            int im = (new Random().nextInt(52))+(int)('A');
            if(im>'Z'){
                im+=6;
            }
            System.out.println((char)im);
        }
    }
}
