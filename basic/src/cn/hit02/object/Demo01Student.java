package cn.hit02.object;

public class Demo01Student {
    public static void main(String[] args) {
        Student xiaoming = new Student("小明",12);
        System.out.println(xiaoming.getAge());
        System.out.println(xiaoming.getName());
        xiaoming.eat();
    }
}
