package W0413a.chatRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王承尧
 * @Date 2021/4/13 3:44 下午
 */
public class Server {

}

class ServerThread implements Runnable{
    private  ServerSocket ss;
//    {
//        try {
//            ss = new ServerSocket(9001);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public ServerThread(ServerSocket ss) {
        this.ss = ss;
    }

    @Override
    public synchronized void run() {

        try {
            Socket s = this.ss.accept();

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            byte[] buf = new byte[1024];
            while(true){
                int len = is.read(buf);
                System.out.println(Thread.currentThread().getId()+new String(buf));
                os.write(buf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
