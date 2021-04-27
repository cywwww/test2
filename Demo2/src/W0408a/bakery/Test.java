package W0408a.bakery;

/**
 * @Author 王承尧
 * @Date 2021/4/8 9:10 下午
 */
public class Test {
    public static void main(String[] args) {
        BasketStack bs = new BasketStack();
        Producer p = new Producer(bs); //产生一个生产者
        Consumer c = new Consumer(bs); //产生一个消费者
        new Thread(p).start(); //启动生产者线程
        new Thread(c).start(); //启动消费者线程

    }
}
