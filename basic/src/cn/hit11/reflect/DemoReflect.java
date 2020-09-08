package cn.hit11.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DemoReflect {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.hit11.reflect.Student");
        Field[] fieldsAll = clazz.getDeclaredFields();  //获取所有成员变量
        for(Field field:fieldsAll){
            System.out.println(field);
        }
        /*
        public java.lang.String cn.hit11.reflect.Student.id
        private java.lang.String cn.hit11.reflect.Student.name
        private java.lang.String cn.hit11.reflect.Student.sex
        public java.lang.String cn.hit11.reflect.Student.address
        */

        Field[] fields = clazz.getFields();          //获取public成员变量
        for(Field field:fields){
            System.out.println(field);
        }
        /*
        public java.lang.String cn.hit11.reflect.Student.id
        public java.lang.String cn.hit11.reflect.Student.address
        */

        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constractor:constructors){
            System.out.println(constractor);
        }
        Constructor constructor = clazz.getConstructor(String.class, String.class, String.class, String.class);
        Object student1 = constructor.newInstance("11S11111", "小明", "男", "深圳");


        Field address = clazz.getDeclaredField("address");
        Object value = address.get(student1);
        System.out.println(value);    //深圳
        address.set(student1, "北京");
        System.out.println(student1);

        //暴力反射，获取修改私有成员
        Field sex = clazz.getDeclaredField("sex");
        System.out.println(sex);
        //sex.get(student1);
        sex.setAccessible(true);  //暴力反射
        sex.set(student1, "女");
        System.out.println(student1);


        Method method1 = clazz.getDeclaredMethod("like", String.class);
        System.out.println(method1);
        System.out.println(method1.getName());
        method1.invoke(student1, "小红");

    }
}
