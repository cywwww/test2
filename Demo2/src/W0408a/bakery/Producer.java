package W0408a.bakery;

import W0408a.bakery.inter.Push;

/**
 * @Author 王承尧
 * @Date 2021/4/8 8:27 下午
 */
public class Producer implements Runnable {
    //勤奋生产
    BasketStack  bs = null;
    public Producer(BasketStack bs){
        this.bs = bs;
    }

    @Override
    public synchronized void run() {
        for(int i=1;i<=10;i++)
        {
            Bread bread = new Bread(i);
            System.out.println("生产了 :" + bread);
            bs.push(bread);

            try
            {
//                Thread.sleep(1000);
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
