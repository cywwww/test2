package W0412a;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王承尧
 * @Date 2021/4/12 7:30 下午
 */
public class Server1 extends ServerSocket {
     private static final int SERVER_PORT = 10000;
    public Server1() throws IOException {
        super(SERVER_PORT);
        try{
            System.out.println("启动服务器");
            while(true){
    Socket socket = this.accept();

new ServerThread(socket);//每当收到一个socket就创建一个线程
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        finally{
            this.close();
        }
    }


    public static void main(String args[]) throws IOException{
     new Server1();
 }

}