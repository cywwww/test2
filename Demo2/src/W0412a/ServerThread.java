package W0412a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author 王承尧
 * @Date 2021/4/12 7:31 下午
 */
public class ServerThread extends Thread{
    private Socket client;
    private BufferedReader in;
    public ServerThread(Socket client) {
        super();
        this.client = client;
        try {

            this.start();
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(
                    client.getInputStream()));// 得到客户端的输入流
            System.out.println(in.readLine());//控制台输入信息
            client.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
