package W0408a.bakery;

import W0408a.bakery.inter.Pop;

/**
 * @Author 王承尧
 * @Date 2021/4/8 8:27 下午
 */
public class Consumer implements Runnable{
    //我是消费大爷
    BasketStack bs =null;
    public Consumer(BasketStack bs){
        this.bs = bs;
    }


    @Override
    public synchronized void run() {
        for (int i = 1; i <= 10; i++) {
            Bread b = bs.pop();
            System.out.println("消费了"+b);

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
