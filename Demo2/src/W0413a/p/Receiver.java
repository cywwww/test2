package W0413a.p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收数据
 * @Author 王承尧
 * @Date 2021/4/13 3:51 下午
 */
public class Receiver {
    public static void main(String[] args) throws SocketException, IOException {
        byte[] buf = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buf,buf.length);//创建数据包

        DatagramSocket ds = new DatagramSocket(9001);//创建DatagramSocket用于接收

        ds.receive(dp);//等待接收数据

        byte[] data = dp.getData();//将数据返回成字节数组
        System.out.println(new String(data));//打印输出

        ds.close();//关闭资源

    }
}
