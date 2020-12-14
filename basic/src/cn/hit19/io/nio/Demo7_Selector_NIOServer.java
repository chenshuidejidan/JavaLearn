package cn.hit19.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Demo7_Selector_NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();

        //1. 绑定端口，设置非阻塞
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);

        //2. serverSocketChannel的连接事件注册到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //3. 循环等待客户端的连接
        while(true){
            if(selector.select(1000)==0){
                System.out.println("服务器阻塞等待了一秒，无事发生");
                continue;
            }
            //4. 获取有事件的selectionKeys集合，并获得对应Channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                if(selectionKey.isAcceptable()){ //是连接事件，说明有新的客户端来连接

                    // accept不会阻塞了，因为确实有连接事件来了！！而不是BIO的一直等待连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功 生成了一个 socketChannel " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false); //设置非阻塞
                    // 注册到selector，关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("该客户端连接后 ，目前注册的selectionkey 数量=" + selector.keys().size()); //2,3,4..
                }else if(selectionKey.isReadable()){
                    //获取OP_READ事件的channel
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //获取之间注册时关联的buffer
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
                    if(channel.read(buffer)>0){
                        String msg = new String(buffer.array()).trim();
                        System.out.println("收到客户端消息"+ msg);
                        channel.write(ByteBuffer.wrap("OK".getBytes())); //避免关闭客户端循环读问题
                    }else{
                        System.out.println("客户端关闭连接");
                        selectionKey.channel();
                    }
                }
                //移除key，防止重复操作
                iterator.remove();
            }
        }
    }
}
