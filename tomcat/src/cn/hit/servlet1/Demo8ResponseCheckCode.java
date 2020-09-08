package cn.hit.servlet1;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo8")
public class Demo8ResponseCheckCode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int height = 50;
        int width = 100;
        //创建图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //填充背景
        Graphics g = image.getGraphics();   //画笔对象
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        //画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width-1, height-1);

        //写验证码
        g.setColor(Color.black);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i=0; i<4; i++) {   //随机生成字母
            char ch = str.charAt(new Random().nextInt(str.length()));
            g.drawString(String.valueOf(ch), width/5*(i+1), height/2);
        }

        //干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        //输出图片
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
