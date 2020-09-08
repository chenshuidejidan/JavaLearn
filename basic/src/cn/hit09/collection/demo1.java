package cn.hit09.collection;

import java.util.ArrayList;
import java.util.Collection;

public class demo1 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("小明");
        coll.add("小芳");
        coll.add("小明");
        coll.remove("小明");
        System.out.println(coll);

    }
}
