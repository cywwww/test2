package thread.pc;

import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/13 11:58 下午
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception{
        ArrayList list = new ArrayList();

        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));
        t1.setName("码农");
        t2.setName("甲方");

        t1.start();
        t2.start();
    }
}

class Producer extends Thread{
    private ArrayList list;

    public Producer(ArrayList list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产（使用死循环模拟一直生产）
        int i = 0;
        while(i<10){
            //给仓库对象list加锁。
            synchronized (list){
                while (list.size() > 0 ){//大于0，说明仓库中已经有一个元素了

                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                }
                //程序既然执行到了这里，说明仓库中空了。否则会一直在上面等待
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName()+"生产了："+obj);
                //唤醒消费者进行消费
                list.notifyAll();
                i++;
            }
        }

    }

}

class Consumer implements Runnable{

    private ArrayList list = new ArrayList();

    public Consumer(ArrayList list) {
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<10){
            synchronized (list){
                while (list.size()==0){//当集合中没有元素时，让其进行等待
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //程序既然到了这里，说明集合中有元素进行消费
            Object obj = list.remove(0);
            System.out.println(Thread.currentThread().getName()+"消费了："+obj);
            list.notifyAll();//唤醒生产者干活
            i++;
        }
    }
}
