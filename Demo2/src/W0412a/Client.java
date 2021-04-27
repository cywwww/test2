package W0412a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/12 6:05 下午
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //1、创建Socket对象
            InetAddress ia = InetAddress.getByName("LocalHost");
            Socket s = new Socket(ia,9001);


            //2、获取流
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            boolean flag = true;
            while(flag){
                //4、发一个请求给客户端
                String str = "王:";
                str += sc.nextLine();
                os.write(str.getBytes(StandardCharsets.UTF_8));
                os.flush();

                //4、客户端获取服务端发过来的信息
                byte[] buf = new byte[1024];
                int len = is.read(buf);
                System.out.println(new String(buf));
                if (str.equals("GoodBye")) {
                    break;
                }
            }

            os.close();is.close();
            s.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
