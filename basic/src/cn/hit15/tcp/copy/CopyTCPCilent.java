package cn.hit15.tcp.copy;

import java.io.*;
import java.net.Socket;

public class CopyTCPCilent {
    public static void main(String[] args) throws IOException, InterruptedException {

        while (true) {
            Socket socket = new Socket("127.0.0.1", 8888);
            String fileName = "";
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            fileName = new String(bytes, 0, len);
            if("close".equals(fileName)){
                System.out.println("服务器正在关闭连接...");
                Thread.sleep(2000);
                socket.close();
                break;
            }

            System.out.println("收到文件："+fileName);
            System.out.println("正在下载....");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\"+fileName));
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes,0,len);
                bos.flush();
            }
            System.out.println("文件"+fileName+"接收完成");
            bos.close();
            socket.close();
        }

    }
}
