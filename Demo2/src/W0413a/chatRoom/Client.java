package W0413a.chatRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/13 4:35 下午
 */
public class Client {

}

class ClientThread implements Runnable{
    private Socket s;
    private String name;
//    {
//        try {
//            s = new Socket("127.0.0.1",9001);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public ClientThread(String name,Socket s){
        this.name = name;
        this.s = s;
    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {

            InputStream is = s.getInputStream();
            OutputStream os =  s.getOutputStream();

            byte[] buf;
            while(true){
                String str = this.name+":"+sc.nextLine();
                buf = str.getBytes(StandardCharsets.UTF_8);
                os.write(buf);

                int len = is.read(buf);
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
