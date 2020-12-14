package cn.hit19.io.myio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket socket = new Socket("127.0.0.1", 8888);

        //创建输出流，发送数据
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        os.write(sc.nextLine().getBytes());

        //创建输入流，读取数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0, len));

        //释放资源
        socket.close();
    }
}
