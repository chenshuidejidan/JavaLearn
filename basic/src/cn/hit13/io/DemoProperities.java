package cn.hit13.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DemoProperities {
    public static void main(String[] args) {
        Properties pp = new Properties();
        pp.setProperty("11201209120","小明");
        pp.setProperty("11201209121","小红");
        pp.setProperty("11201209122","小蓝");
        pp.setProperty("11201209123","小绿");
        Set<String> keys= pp.stringPropertyNames();
        System.out.println(keys);

        try(FileWriter fw = new FileWriter("D:\\a.txt");){
            pp.store(fw,"中文some coments...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("D:\\b.txt");){
            pp.store(fos, "中文some coments...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        pp.clear();
        try(FileReader fr = new FileReader("D:\\b.txt")){
            pp.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Map.Entry<Object, Object> entry : pp.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
}
