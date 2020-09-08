package cn.hit06.time;

import java.util.Calendar;
import java.util.Date;

public class DemoCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();  //返回Calendar类的子类对象，多态
        int year = c.get(Calendar.YEAR);     //Calendar.YEAR是YEAR字段值，为1
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        System.out.println(year+"-"+(month+1)+"-"+date);

        c.set(Calendar.YEAR, 2222);
        c.set(3333, 11,12);
        c.add(Calendar.YEAR, -3);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        date = c.get(Calendar.DATE);
        System.out.println(year+"-"+(month+1)+"-"+date);

        Date ddate = c.getTime();
        System.out.println(ddate);

    }
}
