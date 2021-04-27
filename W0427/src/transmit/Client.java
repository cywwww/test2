package transmit;

import serializablepack.vo.Pet;
import serializablepack.vo.Student;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Author 王承尧
 * @Date 2021/4/27 6:09 下午
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //1、创建socket对象
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        Socket s = new Socket(ia,9001);

        //2、获取流
        OutputStream is = s.getOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(is);

        oos.writeObject(new Student("叶秋",19,"123",99f,new Pet("柴犬",2)));

        oos.flush();
        oos.close();

    }
}
