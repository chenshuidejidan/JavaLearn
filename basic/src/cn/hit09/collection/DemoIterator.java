package cn.hit09.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class DemoIterator {
    public static void main(String[] args) {
        Collection<String> coll = new HashSet<>();
        coll.add("小明");
        coll.add("小红");
        coll.add("小芳");
        coll.add("小王");
        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        for (String s : coll) {
            System.out.println(s);
        }
    }
}
