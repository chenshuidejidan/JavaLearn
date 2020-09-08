package cn.hit03.arraylist;

import java.util.ArrayList;

public class ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> list_b = new ArrayList<>();    //泛型只能是引用类型，基本类型要用包装类型
        list_b.add(1);
        list_b.add(3);
        list_b.add(2);
        list_b.add(3);
        list_b.add(4);
        System.out.println(list_b);

        ArrayList<Integer> list_c = new ArrayList<Integer>();

    }
}
