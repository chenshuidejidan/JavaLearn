package cn.hit19.io.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client implements Runnable{
    private static Charset charset = Charset.forName("utf-8");
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
                socket = new Socket(host, port);
                Scanner sc = new Scanner(System.in);
                System.out.print("请输入：");
                while(true){
                    String s = sc.nextLine();
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(s.getBytes());
                }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Client("localhost",6666)).run();
    }
}
