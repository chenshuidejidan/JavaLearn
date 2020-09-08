package cn.hit09.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DemoTreeMap {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("01", "zhangsan");
        map.put("02", "lisi");
        map.put("03", "wangwu");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();


        //使用keySet遍历
        Set<String> keySet = map.keySet();//先获取map集合的所有键的Set集合

        Iterator<String> it = keySet.iterator();//有了Set集合，就可以获取其迭代器。

        while(it.hasNext()){
            String key = it.next();
            String value = map.get(key);//有了键可以通过map集合的get方法获取其对应的值。
            System.out.println("key: "+key+"-->value: "+value);//获得key和value值
        }



        //使用entrySet遍历

        //将关系集合entrySet进行迭代，存放到迭代器中
        Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();

        while(it2.hasNext()){
            Map.Entry<String, String> me = it2.next();//获取Map.Entry关系对象me
            String key2 = me.getKey();//通过关系对象获取key
            String value2 = me.getValue();//通过关系对象获取value

            System.out.println("key: "+key2+"-->value: "+value2);
        }


        //entrySet和for each
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String s = "key: " + entry.getKey() + "---->value: " + entry.getValue();
            System.out.println(s);
        }


    }
}
