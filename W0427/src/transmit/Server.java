package transmit;

import serializablepack.vo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王承尧
 * @Date 2021/4/27 6:17 下午
 */
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss = new ServerSocket(9001);

        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        Student o = (Student) ois.readObject();

        System.out.println(o);
        ois.close();

    }
}
