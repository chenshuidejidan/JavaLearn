package xml.jsoupXpath;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupXpath {
    public static void main(String[] args) throws IOException {
        String path = JsoupXpath.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        //创建JXDocument
        JXDocument jxDocument = JXDocument.create(document);

        System.out.println(jxDocument);
        System.out.println("=================================");

        List<JXNode> jxNodes = jxDocument.selN("//student");
        jxNodes.forEach(jxNode -> {
            System.out.println(jxNode);
        });

    }
}
