package nio.groupChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT=6667;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        try {
            while(true){
                if(selector.select(2000)==0){
                    //System.out.println("2秒内无事发生，等待客户端。。。");
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){  //处理连接事件
                        SocketChannel socketChannel = listenChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println(socketChannel.getRemoteAddress()+" 上线了...");
                    }
                    if(key.isReadable()){   //处理读
                        readData(key);
                    }
                    iterator.remove();  //删除，防止重复处理
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取客户端消息
    private void readData(SelectionKey key){
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            if(channel.read(buffer)>0){
                String msg = new String(buffer.array());
//                buffer.clear(); //如果用attachment每次都是同一个buffer，那么读取之后要清空，不然每次都接着，消息越来越长
                System.out.println("from"+channel.getRemoteAddress()+":"+msg);
                //转发消息
                sendMsgToOtherClients(msg, channel);
                channel.write(ByteBuffer.wrap("OK".getBytes()));
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress()+"离线了...");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    //转发消息
    private void sendMsgToOtherClients(String msg, SocketChannel selfChannel){
        System.out.println("服务器转发消息...");
        for(SelectionKey key : selector.keys()){
            SocketChannel channel = null;
            if(key.channel() instanceof SocketChannel){ //要判断，因为还有ServerSocketChannel
                channel = (SocketChannel)key.channel();
                if(channel!=selfChannel){
                    ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                    try {
                        channel.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    buffer.clear();
                }
            }
        }
    }

    public static void main(String[] args) {
        new GroupChatServer().listen();
    }
}
