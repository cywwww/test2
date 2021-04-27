package thread;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Properties;

/**
 * @Author 王承尧
 * @Date 2021/4/5 2:56 下午
 */
public class ThreadTest {
    public static void main(String[] args) throws IOException{
        Thread t = new Thread(new Mythread());
        t.setName("t");
        t.start();

        Properties p = new Properties();
        FileReader fr = null;
        File f = new File("../Demo2/src/properties.properties");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
             fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        p.load(fr);

        System.out.println(p.getProperty("pwd"));


        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();

    }
}

class Mythread extends Thread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId()+"--->"+i);
        }
    }
}
