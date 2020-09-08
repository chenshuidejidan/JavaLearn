package cn.hit09.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DemoHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1120110128", "小明");
        map.put("1120110126", "小红");
        map.put("1120110127", "小黄");
        map.put("1120110129", "小蓝");
        System.out.println(map);
        Set<String> order1 = map.keySet();
        for(String key : order1){
            System.out.println(key);
        }
        System.out.println("-------------------------");
        System.out.println(map.get("1120110129"));
        System.out.println(map.get("1120110129"));
        Set<String> order2 = map.keySet();
        for(String key : order2){
            System.out.println(key);
        }
    }
}
