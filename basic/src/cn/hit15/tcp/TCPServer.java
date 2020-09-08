package cn.hit15.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器的ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);

        //获取请求的客户端对象Socket
        Socket socket = serverSocket.accept();

        //读取数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0, len));

        //发送数据
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        os.write(sc.nextLine().getBytes());

        //释放资源ServerSocket 和 Socket
        socket.close();
        serverSocket.close();
    }
}
