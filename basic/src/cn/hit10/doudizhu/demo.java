package cn.hit10.doudizhu;

public class demo {
    public static void main(String[] args) {
        Poker poker = new Poker();
        PlayMethod doudizhu = new PlayMethod();
        System.out.println("游戏开始");
        System.out.println("现在大家的牌如下:");
        doudizhu.showPoker();
        System.out.println("获得一副扑克牌："+(poker.poker));
        poker.shuffle();
        System.out.println("洗牌："+poker.poker);
        doudizhu.divide(poker);
        System.out.println("发牌：");
        System.out.println("看牌：");
        doudizhu.showPoker();
    }
}
