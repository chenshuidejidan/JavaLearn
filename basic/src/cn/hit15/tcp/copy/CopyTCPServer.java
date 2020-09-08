package cn.hit15.tcp.copy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CopyTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);


        String path = "F:\\play\\";
        Scanner sc = new Scanner(System.in);
        String fileName = "";

        //开始发送了
        while (true) {
            Socket socket = serverSocket.accept();
            OutputStream os = socket.getOutputStream();
            fileName = sc.nextLine();
            if("close".equals(fileName)){
                break;
            }
            os.write(fileName.getBytes());

            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(path + fileName));
            byte[] bytes = new byte[1024];
            int len = 0;

            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes,0,len);
            }
            System.out.println("文件"+fileName+"发送完成");
            socket.close();
        }

        serverSocket.close();
    }
}
