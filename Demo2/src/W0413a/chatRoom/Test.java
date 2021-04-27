package W0413a.chatRoom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Author 王承尧
 * @Date 2021/4/13 4:52 下午
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        InetAddress ia = InetAddress.getByName("LocalHost");
//        Socket s = new Socket("127.0.0.1",9001);
//        ServerSocket ss = new ServerSocket(9001);
//        Socket s = new Socket("127.0.0.1",9001);

        new Thread(new ServerThread(new ServerSocket(9001))).start();
        new Thread(new ServerThread(new ServerSocket(9002))).start();
        new Thread(new ClientThread("小王",new Socket("127.0.0.1",9001))).start();



//        new Thread(new ServerThread()).start();
//
//        new Thread(new ClientThread("小王")).start();

    }
}
