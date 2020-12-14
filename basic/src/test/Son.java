package test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * @Auther: c
 * @Date: 2020/11/19 - 11 - 19 - 21:16
 * @Description: test
 * @Version: 1.0
 */
public class Son implements Cloneable{
    public static void main(String[] args) {
        System.out.println(LocalTime.now().getHour()+":"+ LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());

    }
}
