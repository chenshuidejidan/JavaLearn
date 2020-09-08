package cn.hit06.time;

import java.util.Date;

public class DemoDate2 {
    public static void main(String[] args) {
        Date date = new Date(0);
        System.out.println(date);
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);
    }
}
