package demo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author 王承尧
 * @Date 2021/4/25 4:24 下午
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("ss");
        String[] s = new String[a.size()];
        s = pCell(a, s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }


        System.out.println("___________________");

        String[] as = {"1","2","asd","ddd"};
        String[] bs = arr(as,as);
        for (int i = 0; i < bs.length; i++) {
            System.out.println(bs[i]);
        }
    }

    /**
     * 定义一个方法，把任意参数类型的集合中的数据安全地复制到相应类型的数组中
     * @param <E>
     * @return
     */
    public static <E> E[] pCell(Collection<?> c,E[] arr){

        return  c.toArray(arr);
    }


    /**
     * 定义一个方法，把任意参数类型的一个数组中的数据安全地复制到相应类型的另一个数组中
     * @param <E>
     * @return
     */
    public static <E> E[] arr(E[] a,E[] b){
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
}
