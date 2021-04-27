package W0412a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/12 4:48 下午
 */
public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //1、创建ServerSocket对象
            ServerSocket ss = new ServerSocket(9001);
            System.out.println("等待客户端链接");

            //2、调用监听
            Socket s = ss.accept();
            System.out.println("链接成功");

            //3、通过Socket对象获取输入输出流
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            boolean flag = true;
            while(flag){
                byte[] buff = new byte[1024];
                int len = is.read(buff);
                String str = "";
                System.out.println((str = new String(buff,0,len)));

//                String serverToInfo = "已收到";
                String st = sc.nextLine();
                os.write(st.getBytes(StandardCharsets.UTF_8));
                os.flush();
                if (st.equals("GoodBye")) {
                    break;
                }
            }

            os.close();is.close();
            s.close();ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
