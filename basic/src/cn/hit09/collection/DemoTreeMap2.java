package cn.hit09.collection;

import java.rmi.RemoteException;
import java.util.*;

public class DemoTreeMap2 {
    public static void main(String[] args) {

        //构造的时候传入Comparator,使用匿名内部类
//        TreeMap<Student, String> map = new TreeMap<Student, String>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int num = o1.getAge() - o2.getAge();
//                int num2 = (num == 0) ? o1.getName().compareTo(o2.getName()) : num;
//                return num2;
//            }
//        });


        //使用Lambda表达式
        TreeMap<Student, String> map = new TreeMap<Student, String>((o1, o2) -> {
            int num = o1.getAge() - o2.getAge();
            int num2 = (num == 0) ? o1.getName().compareTo(o2.getName()) : num;
            return num2;
        });


        method();
        Student s1 = new Student("小明", 13);
        Student s2 = new Student("小红", 10);
        map.put(s1, "一班");
        map.put(s2, "二班");

        //map.put(null, "一班");   使用compareTo 比较，不能传入 null 的 key

        //遍历集合
        for ( Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
    public static void method(){
        int[] a = {1,2};
        try{
            System.out.println(a[2]);
        }
        catch(Exception e){
            System.out.println("出错了：" + e);
            e.printStackTrace();

        }
    }
}
