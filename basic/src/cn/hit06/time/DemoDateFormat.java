package cn.hit06.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date= new Date();  //得到当前时间
        String standardDate = simpleDateFormat.format(date);
        System.out.println(standardDate);  //2020-07-28 21:24:36

        date = simpleDateFormat.parse(standardDate);   //必须和构造方法中的格式一样
        System.out.println(date);   //Tue Jul 28 21:28:38 CST 2020
    }
}
