package cn.hit19.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class Server {
    static class messageHandler implements Runnable{
        private Socket socket;
        public messageHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("已连接" + socket.getInetAddress() + "，等待消息");
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes)) > 0) {
                    System.out.println("收到来自"+socket.getInetAddress()+"的消息："+new String(bytes, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            while (true) {
                System.out.println("等待连接");
                Socket socket = serverSocket.accept();
                new Thread(new messageHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }

    }
}
