package W0413a.p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @Author 王承尧
 * @Date 2021/4/13 3:51 下午
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        String str = "你好哇";//需要传输的语句
        byte[] buf = str.getBytes(StandardCharsets.UTF_8);//转换成字节数组，方便数据包使用
        DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",9001));
        //数据包，客户端这边必须使用传输地址

        DatagramSocket ds = new DatagramSocket();//用于传输的Socket对象

        ds.send(dp);//开始传输

        ds.close();//关闭资源
    }
}
