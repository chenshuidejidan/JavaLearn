package cn.hit02.object;

import java.sql.SQLOutput;

class Student {

    //成员变量
    private String name;
    private int age;

    //构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }


    //成员方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name+"吃饭");
    }
    public void sleep(){
        System.out.println(this.name+"睡觉");
    }
    public void learn(){
        System.out.println(this.name+"学习");
    }
}
