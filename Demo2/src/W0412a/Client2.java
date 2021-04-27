package W0412a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author 王承尧
 * @Date 2021/4/12 7:33 下午
 */
public class Client2 {

    private String name;
    private Socket socket;
    private PrintWriter out;//相当于向外写文件，所以用out
    private static int count = 1;
    public Client2(String clientName,String name) {
        this.connect();
        this.name = name;

    }


    public Client2(int i,String name) {
        this(null,name);
        this.connect();
    }


    public void connect() {
        try {
            socket = new Socket("127.0.0.1", 10000);
            System.out.println("请输入信息：");







                out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader line = new BufferedReader(new InputStreamReader(
                        System.in));// 从控制台输入信息
                out.println(this.name+":"+line.readLine());// 输入信息到服务器

            out.close();
            socket.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
