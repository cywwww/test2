package dao;

/**
 * @Author 王承尧
 * @Date 2021/4/16 4:52 下午
 */
public class Demo4 {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(cl);
        System.out.println(cl+"的父加载器"+cl.getParent());
        System.out.println(cl.getParent()+"的父加载器"+cl.getParent().getParent());

    }
}
