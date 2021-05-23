package test;

import com.sun.media.sound.SoftTuning;

import java.lang.ref.SoftReference;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for(String s : list){
            if("2".equals(s)){
                list.remove(s);
            }
        }

        System.out.println(list);





    }
}

