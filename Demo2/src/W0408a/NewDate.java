package W0408a;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王承尧
 * @Date 2021/4/8 8:22 下午
 */
public class NewDate {
    public static void main(String[] args) {
        while (true){
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(d));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
