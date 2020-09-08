package cn.hit10.doudizhu;

import java.util.ArrayList;
import java.util.Random;

public class Poker {
    private ArrayList<String> color;
    private ArrayList<String> number;
    public ArrayList<String> poker;

    public Poker(){
        color = new ArrayList<>();
        color.add("红桃");
        color.add("黑桃");
        color.add("方块");
        color.add("梅花");

        number = new ArrayList<>();
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        number.add("J");
        number.add("Q");
        number.add("K");
        number.add("A");

        poker = new ArrayList<>();
        for(String color_i:color){
            for(String number_i:number){
                poker.add((color_i+number_i));
            }
        }
        poker.add("大王");
        poker.add("小王");
    }
    public void shuffle(){
        String temp = null;
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        int change_index = 0;
        for(int i = this.poker.size()-1; i>=1; i--){
            temp = poker.get(i);
            change_index = r.nextInt(i);
            poker.set(i, poker.get(change_index));
            poker.set(change_index, temp);
        }
    }

    @Override
    public String toString() {
        return "Poker{" +
                "color=" + color +
                ", number=" + number +
                ", poker=" + poker +
                '}';
    }

    public void show(){
        System.out.println(this.poker);
    }
}
