package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 王承尧
 * @Date 2021/4/12 9:16 下午
 */
public class TestTimer {
    public static void main(String[] args) throws Exception{
        Timer t = new Timer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse("2021-04-12 21:23:00:000");
        t.schedule(new LogTimerTask(),d,1000*3);
    }
}

class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("数据已备份");
    }
}
