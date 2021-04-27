package W0408a.bakery;

/**
 * @Author 王承尧
 * @Date 2021/4/8 8:27 下午
 */
public class BasketStack{
   int index = 0;//指针
    Bread[] arr = new Bread[4];

    public synchronized void push(Bread b){
        while (index==arr.length){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        this.arr[index] = b;
        index++;
    }

    public synchronized Bread pop() // 拿出方法
    {
        while(index == 0)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.notify(); //唤醒一个wait的线程
//        this.notifyAll();//唤醒所有wait的线程
        index --;
        return arr[index];
    }
}
