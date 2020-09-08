package cn.hit10.doudizhu;

import java.util.ArrayList;

public class PlayMethod {
    private ArrayList<String> player1;
    private ArrayList<String> player2;
    private ArrayList<String> player3;
    private ArrayList<String> left;

    public PlayMethod() {
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();
        player3 = new ArrayList<>();
        left = new ArrayList<>();
    }

    public void divide(Poker poker) {
        this.player1.clear();
        this.player2.clear();
        this.player3.clear();
        for (int i = 0; i < 54; i++) {
            if (i < 51) {
                if (i % 3 == 0) {
                    this.player1.add(poker.poker.get(i));
                } else if (i % 3 == 1) {
                    this.player2.add(poker.poker.get(i));
                } else {
                    this.player3.add(poker.poker.get(i));
                }
            }
            else{
                left.add(poker.poker.get(i));
            }
        }
    }
    public void showPoker(){
        System.out.println("player1:"+(this.player1));
        System.out.println("player2:"+(this.player2));
        System.out.println("player3:"+(this.player3));
        System.out.println("left:"+(this.left));
    }
}
