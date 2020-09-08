package cn.hit04.multiState;

public class Animal {
    String sex;
    String color;
    public Animal(String sex){
        this.sex = sex;
        this.color = "animal color";
    }
    public Animal(){
        this.sex = "male animal";
        this.color = "red animal";
    }
    public void show(){
        System.out.println("i am an animal");
        System.out.println(this.sex + this.color);
    }

}
