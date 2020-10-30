package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TestArrayList {
    @Test
    public void testvector() {
        // 初始化Vector
        Vector<String> vector = new Vector();
        vector.add("关注公众号");
        vector.add("Java3y");
        vector.add("买Linux可到我下面的链接，享受最低价");
        vector.add("给3y加鸡腿");
        // 遍历Vector
        for (int i = 0; i < vector.size(); i++) {
            // 比如在这执行vector.clear();
            new Thread(() -> vector.clear()).start();
            System.out.println(vector.get(i));
        }
    }

    @Test
    public void testConcurrentHashMap(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "哈");
        map.put(2, "喽");
        map.put(3, "我");
        map.put(4, "的");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> entry:entries){
            new Thread(()-> map.clear()).start();
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }

    @Test
    public void testHashMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "哈");
        map.put(2, "喽");
        map.put(3, "我");
        map.put(4, "的");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> entry:entries){
            new Thread(()-> map.clear()).start();
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }

    
}
