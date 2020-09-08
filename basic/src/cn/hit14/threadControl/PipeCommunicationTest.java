package cn.hit14.threadControl;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Sender implements Runnable {
    private PipedWriter writer;
    Sender(PipedWriter writer) {
        this.writer = writer;
    }
    public void run() {
        String str1 = new String("I love you\n");
        String str2 = new String("Do you love me\n");
        try {
            writer.write(str1.toCharArray());
            writer.write(str2.toCharArray());
        } catch (IOException e) {}
    }
}
class Receiver implements Runnable {
    private PipedReader reader;
    public Receiver(PipedReader reader) {
        this.reader = reader;
    }
    public void run() {
        try {
            while(true) {
                char c = (char)reader.read();
                System.out.print(c);
            }
        } catch (IOException e) {}
    }
}
public class PipeCommunicationTest {
    public static void main(String[] args) throws Exception {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter(reader);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender(writer));
        exec.execute(new Receiver(reader));
        Thread.sleep(1000);
        exec.shutdownNow();
    }
}
