package cn.hit03.arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list_a = new ArrayList<>();    // <E>泛型  ArrayList里装的都是同一种引用类型，泛型
        list_a.add("小明");
        list_a.add("小芳");
        list_a.add("小何");
        boolean b = list_a.remove("小芳");
        System.out.println(b);
        list_a.add("小芳");
        System.out.println(list_a.get(1));
        System.out.println(list_a);
        for (int i = 0; i < list_a.size(); i++) {
            System.out.println(list_a.get(i));
        }
    }


}
