package cn.hit09.collection;

import java.util.LinkedHashMap;
import java.util.Set;

public class DemoLinkedHashMap {
    public static void main(String[] args) {
        // 默认是插⼊顺序
        LinkedHashMap<Integer,String> insertOrder = new LinkedHashMap();
        String value = "关注公众号Java3y";
        int i = 0;
        insertOrder.put(i++, value);
        insertOrder.put(i++, value);
        insertOrder.put(i++, value);
        insertOrder.put(i++, value);
        insertOrder.put(i++, value);
//遍历
        Set<Integer> set = insertOrder.keySet();
        for (Integer s : set) {
            String mapValue = insertOrder.get(s);
            System.out.println(s + "---" + mapValue);
        }




        // 设置为访问顺序的⽅式
        LinkedHashMap<Integer,String> accessOrder = new LinkedHashMap(16,
                0.75f, true);
        //String value = "关注公众号Java3y";
        i = 0;
        accessOrder.put(i++, value);
        accessOrder.put(i++, value);
        accessOrder.put(i++, value);
        accessOrder.put(i++, value);
        accessOrder.put(i++, value);

// 访问⼀下key为3的元素再进⾏遍历
        accessOrder.get(3);
// 遍历
        Set<Integer> sets = accessOrder.keySet();
        for (Integer key : sets) {
            System.out.println(key );
        }
    }
}
