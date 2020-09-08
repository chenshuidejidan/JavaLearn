package cn.hit04.multiState;

public class main {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.show();

        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Cat);

        //a.eat();   //报错
        Cat b = new Cat();
        b = (Cat)a;
        b.show();
    }
}
