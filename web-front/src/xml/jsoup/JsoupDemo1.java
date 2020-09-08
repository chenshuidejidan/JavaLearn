package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //获取 xml 的 path，根据 path 获取 Document 对象
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();

        //解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取元素对象
        Elements elements = document.getElementsByTag("name");

        elements.forEach(element -> {
            System.out.println(element.text());
        });
    }
}
