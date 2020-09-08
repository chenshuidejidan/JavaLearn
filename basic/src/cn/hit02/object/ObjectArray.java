package cn.hit02.object;

public class ObjectArray {
    public static void main(String[] args) {
        Student[] a = new Student[2];
        Student xiaoming = new Student("小明",10);
        Student xiaofang = new Student("小芳",12);
        a[0] = xiaoming;
        a[1] = xiaofang;
        System.out.println(a[1].getName());
    }
}
