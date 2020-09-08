package cn.hit04.multiState;

public class Cat extends Animal{
    String name;
    public Cat(String sex, String name) {
        super(sex);
        this.name = name;
    }
    public Cat(){
        this.name = "cat";
        this.color = "red cat";
        this.sex = "male cat";
    }

    @Override
    public void show(){
        System.out.println("i am a cat");
        System.out.println(this.sex + "," + this.color + "," + this.name);
    }

    public void eat(){
        System.out.println("cat is eating");
    }
}
