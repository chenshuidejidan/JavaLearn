package cn.hit04.innerClass;

public class OuterClass {
    int num = 10;
    public class Inner{
        int num = 20;
        public void method(){
            int num = 30;
            System.out.println(num); //30
            System.out.println(this.num); //20
            System.out.println(OuterClass.this.num); //10
        }
    }
}
