package cn.hit01.array;

public class Method {
    public static void print_rectangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("o");
            }
            System.out.println("");
        }
    }
    public static void main (String[]args){
        print_rectangle();
    }
}
