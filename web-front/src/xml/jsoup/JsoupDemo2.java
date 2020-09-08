package xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        URL url  = new URL("https://www.baidu.com/");
        Document document = Jsoup.parse(url, 3000);
        //System.out.println(document);
//        Elements elements = document.getElementsByClass("mnav");
//        System.out.println(elements.size());
//        elements.forEach(element -> {
//            System.out.println(element.text());
//        });

        Elements mnavs = document.select(".mnav");
        mnavs.forEach(mnav->{
            System.out.println(mnav.text());
        });
    }
}
