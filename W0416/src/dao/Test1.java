package dao;

/**
 * @Author 王承尧
 * @Date 2021/4/16 4:56 下午
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(Test1.class.getClassLoader());
        Test2 t2 = new Test2();
        t2.print();
    }

}
