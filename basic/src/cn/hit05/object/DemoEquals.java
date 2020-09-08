package cn.hit05.object;

public class DemoEquals {
    public static void main(String[] args) {
        Person xiaoming = new Person("小明",15);
        Person xiaoming2 = new Person("小明",15);
        Person xiaofang = new Person("小芳",15);
        System.out.println(xiaoming);
        System.out.println(xiaoming == xiaoming2);
        System.out.println(xiaoming.equals(xiaoming2));
        System.out.println(xiaoming.equals(xiaofang));
    }
}
